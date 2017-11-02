package redis;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.bill99.golden.inf.sso.util.CM;
import com.bill99.rm.skeye.rtms.parallel.bo.MerchantLimit;

public class RedisTemplateHelper {
	/**
	 * 缓存key前缀
	 */
	public final static String CACHE_KEY_USERINFO = "USERINFO.";  //用户信息
	public final static String CACHE_KEY_TXNINFO = "TXNINFO.";    //交易信息
	public final static String CACHE_KEY_RATEDATA_CUSTOMER_SET = "RATEDATA.C.SET"; 	// 会员集合Set<MemberCode>
	public final static String CACHE_KEY_RATEDATA_CUSTOMER_TXN = "RATEDATA.C.TXN."; // 会员下的交易TimeDescSortList<TxnCache4Customer>
	public final static String CACHE_KEY_RATEDATA_MERCHANT_TXN = "RATEDATA.M.TXN."; // 商户下的交易
	public final static String CACHE_KEY_RATEDATA_MERCHANT_AMOUNT = "RATEDATA.M.AMT."; // 商户下的交易额
	public final static String CACHE_KEY_OPENED_MERCHANT = "OPENED.MERCHANT"; // 已开通快易花的商户
	
	public final static String CACHE_KEY_MEMBER_INFO = "MamMemberInfo."; //memberInfo
	
	/**
	 * 三合一开关 (限额/规则/黑白名单)(1：打开；0：关闭；默认为1)
	 */
	public final static String RTMS_TRADE_FLAG = "RTMS_TRADE_FLAG";
	
	public static void main(String[] args) {
		URL configURL = RedisTemplateHelper.class.getResource("/properties/log4j.properties");
		PropertyConfigurator.configure(configURL);
		ApplicationContext ac = new FileSystemXmlApplicationContext(new String[]{
						"classpath*:redis/redis_dev.xml"
				});
		RedisTemplate<String, Object> stringRedisTemplate = (RedisTemplate<String, Object>)ac.getBean("stringRedisTemplate");
		RedisTemplate<String, Object> redisObjTemplate = (RedisTemplate<String, Object>)ac.getBean("strObjRedisTemplate");
		RedisTemplate<String, Object> redisHashTemplate = (RedisTemplate<String, Object>)ac.getBean("strHashRedisTemplate");
		
		
		//开关
		/*String val = (String)stringRedisTemplate.opsForValue().get(RTMS_TRADE_FLAG);
		System.out.println(val);*/
		
		/*String mailKey = "noticeType";
		testMailNo(redisHashTemplate, mailKey);*/
		
		/*RedisTemplate<String, MamCustomer> redisTemplate = (RedisTemplate<String, MamCustomer>)ac.getBean("strHashRedisTemplate");
		//String objKey = CACHE_KEY_RATEDATA_MERCHANT_TXN + "10012077336";
		String objKey = CACHE_KEY_MEMBER_INFO + "10012245533";
		System.out.println("objKey="+objKey);
		boolean isExists = redisTemplate.hasKey(objKey);
		System.out.println("[KEY="+objKey+"] isExists="+isExists);
		if(isExists){
			*//**
			 * Test.1>>>单个值
			 *//*
			*//**
			 * 注意：model的package路径，必须与set时的model路径一致,否则抛以下异常
			 * Exception in thread "main" org.springframework.data.redis.serializer.SerializationException: 
			 * com.bill99.rm.skeye.aba.model.MamCustomer; nested exception is java.lang.RuntimeException: 
			 * com.bill99.rm.skeye.aba.model.MamCustomer
			 * Caused by: java.lang.RuntimeException: com.bill99.rm.skeye.aba.model.MamCustomer
			 * at com.bill99.inf.redis.ext.utils.JDKSerializerUtils.deserialize(JDKSerializerUtils.java:60)
			 * at com.bill99.inf.redis.ext.serializer.JdkSerializer.deserialize(JdkSerializer.java:14)
			 * ... 7 more
			 * Caused by: java.lang.ClassNotFoundException: com.bill99.rm.skeye.aba.model.MamCustomer
			 *//*
			MamCustomer objVal = redisTemplate.opsForValue().get(objKey);
			JSONObject jsonObj = JSONObject.fromObject(objVal);
			System.out.println("objVal="+jsonObj.toString());
			*//**
			 * Test.2>>>List
			 *//*
			//queryList(redisTemplate, objKey);
		}*/
		
		//测试redis hash存储java对象
		testHashStoredObj(redisHashTemplate);
	}
	
	
	public static void testMailNo(RedisTemplate<String, Object> redisTemplate, String mailKey){
		//设置值
		//redisHashObjTemplate1.opsForValue().set(mailKey, 1);
		System.out.println("curMailNo:key="+mailKey+"|value="+redisTemplate.opsForValue().get(mailKey));
		System.out.println("nextMailNo:key="+mailKey+"|value="+genMailNo(redisTemplate, mailKey));
		System.out.println("aftergenMailNo, curMailNo:key="+mailKey+"|value="+redisTemplate.opsForValue().get(mailKey));
	}
	
	
	public static String genMailNo(RedisTemplate<String, Object> redisTemplate, String key){
		String returnStr = "";
		int curNo = (Integer)redisTemplate.opsForValue().get(key);
		int nextNo = curNo + 1;
		//更新缓存
		redisTemplate.opsForValue().set(key, nextNo);
		returnStr = RedisTemplateHelper.formatNumWithZero(nextNo, 2);
		return returnStr;
	}
	
	
	public static List<?> queryList(RedisTemplate<String, Object> redisTemplate, String key){
		List resultList = new ArrayList();
		/*List<Object> objList = redisTemplate.opsForList().range(key, 0, -1);
		if(objList!=null && (objList instanceof TimeDescSortList<?>)){
			TimeDescSortList<CacheTxn> dataList  = (TimeDescSortList<CacheTxn>) obj;
			LinkedList<CacheTxn> txnList = dataList.getList();
			System.out.println("[merchantCode="+merchantCode+"] in redis：txnSize="+txnList.size());
			for(CacheTxn data : txnList){
				System.out.println("[CacheTxn:"
						+ "tradeId=" + data.getTradeId()
						+ ", " + "memberCode=" + data.getMemberCode()
						+ ", " + "payAmount=" + data.getPayAmount()
						+ ", " + "txnTime=" + data.getTxnTime()
						+ ", " + "txnStatus=" + data.getTxnStatus()
						+"]");
			}
		}*/
		return resultList;
	}
	
	
	/**
	 * 数字前补零
	 * 最高效简洁的方法：String.format
	 * @param curNum-当前数字
	 * @param maxLen-最终长度
	 * @return
	 */
	public static String formatNumWithZero(int curNum, int maxLen){
		// 0 代表前面补充0         
	    // d代表参数为正数型 
		String newStr = String.format("%0"+maxLen+"d", curNum);
		return newStr;
	}
	
	/**
	 * 测试hash存储对象
	 * @param redisHashTemplate	必须是bean id="strHashRedisTemplate"这个
	 */
	public static void testHashStoredObj(RedisTemplate redisHashTemplate){
		String redisKey = "MERCHANT_LIMIT";
		//>>>>>1.delete
		//redisHashTemplate.opsForHash().delete(redisKey, "1", "2", "3", "4", "99", "100");
		//>>>>>2.put
		//putObjectInHash(redisHashTemplate, redisKey);
		//>>>>>3.get
		getObjectFromHash(redisHashTemplate, redisKey);
	}
	
	/**
	 * opForHash-put
	 * @param redisHashTemplate
	 * @param redisKey
	 */
	public static void putObjectInHash(RedisTemplate redisHashTemplate, String redisKey){
		//single put
		MerchantLimit m1 = new MerchantLimit();
		m1.setId(100L);
		m1.setUpMerchantId("812025145110002");
		m1.setPayMode("0");
		m1.setMinLimit(new BigDecimal(2));
		m1.setMaxLimit(new BigDecimal(3));
		m1.setCreaterCode("nammi100");
		redisHashTemplate.opsForHash().put(redisKey, CM.toString(m1.getId()), m1);
		//map put
		/*Map<String, MerchantLimit> limitMap = new HashMap<String, MerchantLimit>();
		for(int i=1; i<5; i++){
			Long iLong = CM.toLongObj(i);
			MerchantLimit tmp = new MerchantLimit();
			tmp.setId(iLong);
			tmp.setUpMerchantId(CM.toString(i));
			tmp.setMinLimit(new BigDecimal(iLong));
			tmp.setMaxLimit(new BigDecimal(iLong + 99L));
			tmp.setCreaterName("nammi"+i);
			//redis hash中Map的key必须为String
			limitMap.put(CM.toString(i), tmp);
		}*/
		//put in redis:by Map
		//redisHashTemplate.opsForHash().putAll(redisKey, limitMap);
	}
	
	/**
	 * opForHash-get
	 * @param redisHashTemplate
	 * @param redisKey
	 */
	public static void getObjectFromHash(RedisTemplate redisHashTemplate, String redisKey){
		/*System.out.println("=====redis hash stored Object>>>>>getMap  begin=====");
		Map<String, MerchantLimit> merLimitMap = (Map<String, MerchantLimit>)redisHashTemplate.opsForHash().entries(redisKey);
		if(merLimitMap!=null && merLimitMap.size()>0){
			Set<Map.Entry<String, MerchantLimit>> sets = merLimitMap.entrySet();
			for(Iterator<Map.Entry<String, MerchantLimit>> it = sets.iterator(); it.hasNext(); ){
				Map.Entry<String, MerchantLimit> entry = it.next();
				String key = entry.getKey();
				MerchantLimit val = (MerchantLimit)entry.getValue();
				System.out.println("---------------------------------------------------------");
				System.out.println("key="+key+"|value="+val.toString());
				//JSONObject jsonObj = JSONObject.fromObject(merchantLimit);
				//System.out.println(String.format("key=s%,val=s%", key, jsonObj.toString()));
			}
		}
		System.out.println("=====redis hash stored Object>>>>>getMap  end=====");*/
		System.out.println("=====redis hash stored Object>>>>>getList  begin=====");
		List<Object> valList = redisHashTemplate.opsForHash().values(redisKey);
		if(valList!=null && valList.size()>0){
			for(Object obj : valList){
				MerchantLimit tmp = (MerchantLimit)obj;
				System.out.println("---------------------------------------------------------");
				System.out.println("id="+tmp.getId()+"|obj="+tmp.toString());
			}
		}
		//compare txn.payAmount and merchangLimit
		//System.out.println("checkResult: "+compareMerLimit(valList));
		System.out.println("=====redis hash stored Object>>>>>getList  end=====");
	}
	
	
	public static boolean compareMerLimit(List<Object> merLimitList){
		String upMerchantId="812025145110002";
		String merchantTerminalId="12344321";
		String payMode="11";
		BigDecimal payAmount = new BigDecimal(100);
		for(Object data : merLimitList){
			MerchantLimit tmp = (MerchantLimit)data;
			System.out.println("id："+tmp.getId());
			if(!upMerchantId.equals(tmp.getUpMerchantId())){
				continue;
			}
			if(StringUtils.isNotBlank(tmp.getMerchantTerminalId()) && !merchantTerminalId.equals(tmp.getMerchantTerminalId())){
				continue;
			}
			String cachePayMode = tmp.getPayMode();
			if(StringUtils.isNotBlank(cachePayMode) && !("0".equals(cachePayMode) || payMode.equals(cachePayMode))){
				continue;
			}
			//限额单位元：*100
			BigDecimal minLimit = tmp.getMinLimit();
			BigDecimal maxLimit = tmp.getMaxLimit();
			System.out.println(">>>>>[cache merchantLimit] minLimit="+minLimit+",maxLimit="+maxLimit);
			if(minLimit!=null && maxLimit!=null){
				minLimit = minLimit.multiply(new BigDecimal(100));
				maxLimit = maxLimit.multiply(new BigDecimal(100));
				if(minLimit.compareTo(payAmount)!=1 && payAmount.compareTo(maxLimit)!=1){
					System.out.println(">>>>>hit merchantLimit[id="+tmp.getId()+",minLimit="+minLimit+",maxLimit="+maxLimit+"]");
					return true;
				}else{
					continue;
				}
			}else{
				continue;
			}
		}
		return false;
	}
	
}
