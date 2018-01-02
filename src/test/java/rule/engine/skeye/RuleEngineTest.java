package rule.engine.skeye;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.bill99.rm.skeye.enumdata.SystemEnum;
import com.bill99.rm.skeye.parallel.util.CM;
import com.bill99.rm.skeye.rule.engine.DataItem;
import com.bill99.rm.skeye.rule.engine.RuleDataFactory;
import com.bill99.rm.skeye.rule.model.RuleIndex;
import com.bill99.rm.skeye.rule.model.RuleItem;

public class RuleEngineTest {
	public static void main(String[] args) {
		//10以内的随机数，两位小数
		System.out.println("两位小数："+Math.round(Math.random()*1000)/100.0);
		URL configURL = RuleEngineTest.class.getResource("/properties/log4j.properties");
		PropertyConfigurator.configure(configURL);
		
		//ApplicationContext ac = new ClassPathXmlApplicationContext(
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				new String[]{"classpath*:rule/engine/ds-dao-factory.xml",
						"classpath*:redis/redis.xml"
				});
		
		RuleDataFactory rdf = (RuleDataFactory)ac.getBean("ruleDataFactory");
		RedisTemplate<String, List<RtmsTradeApply>> redis = (RedisTemplate<String, List<RtmsTradeApply>>)ac.getBean("strHashRedisTemplate");
		//rdf.initRuleData(SystemEnum.SYS_KYH.getCode());
		rdf.initRuleData(SystemEnum.SYS_UAP.getCode());
		
		for(int i=0; i<10; i++){
			RtmsTradeApply txn = new RtmsTradeApply();
			txn.setTxnTimeEnd(new Date());
			txn.setPayAmount(CM.toLongObj(Math.round(Math.random()*1000)/100.0));
			txn.setMerchantCode("nammi");
			processRule(rdf, txn, redis);
		}
	}
	
	
	public static void processRule(RuleDataFactory rdf, RtmsTradeApply txn, RedisTemplate<String, List<RtmsTradeApply>> redis){
		List<RuleItem> ruleList = rdf.getValidRuleList(SystemEnum.SYS_UAP.getCode());
		//根据指标模板编号，获取指标集合：动态指标才需要此行代码,获取该模板关联的多个指标
		Collection<RuleIndex> collection = rdf.getAllRuleIndexListByTemplateCode("UAPLong");
		//是否新开通会员
		boolean isOpenNew = true;
		String memberCode = txn.getMemberCode();
		//缓存key:统计过去一天的总支付金额，需要缓存List<RtmsTradeApply>
		String redisKey = "KYH_01_002#@#"+memberCode+"#@#txnList";
		List<RtmsTradeApply> list = new ArrayList<RtmsTradeApply>();
		if(isOpenNew){
			//刷新缓存：清除超过1天的交易的支付金额，加入当前交易的支付金额
			for(RuleIndex ri : collection){//动态指标循环获取参数，基本指标不需要循环
				list = redis.opsForValue().get(redisKey);
				if(list==null){
					list = new ArrayList<RtmsTradeApply>();
				}
				for(int i=0; i<list.size();){
					RtmsTradeApply data = list.get(i);
					long inLong = txn.getTxnTimeStart().getTime() - data.getTxnTimeStart().getTime();
					//剔除超过1天的
					if(inLong>24*3600*1000){
						list.remove(i);
					}else{
						i++;
					}
				}
				list.add(txn);
				redis.opsForValue().set(redisKey, list);//重新缓存
			}
		}
		
		//准备规则数据
		for(int i=0; i<ruleList.size(); i++){
			RuleItem ruleItem = ruleList.get(i);
			Set<RuleIndex> indexSet = ruleItem.getAllUsedIndexSet();
			DataItem dataItem = new DataItem();
			//准备指标数据
			for(RuleIndex index : indexSet){
				String indexCode = index.getCode();
				if("KYH_01_002_01".equals(indexCode)){	//总额度
					/*Map conMap = new HashMap();
					conMap.put("memberCode", memberCode);
					FcsAcctRegister reg = fcsAcctRegisterService.findFcsAcctRegisterByMap(conMap);
					Long quotaAmt = reg.getQuotaAmt();
					dataItem.putSingleLong(indexCode, quotaAmt);*/
					dataItem.putSingleLong(indexCode, 1000L);
				}else if("KYH_01_002_02".equals(indexCode)){	//成交支付金额
					Long totalAmt = 0l;
					for(int j=0; j<list.size(); j++){
						RtmsTradeApply data = list.get(i);
						if(data!=null && data.getStatus()!=null && data.getStatus().longValue()==2l){
							totalAmt += data.getPayAmount();
						}
					}
					dataItem.putSingleLong(indexCode, totalAmt);
				}
			}
		}
	}
}
