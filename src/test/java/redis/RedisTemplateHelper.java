package redis;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.bill99.rm.skeye.aba.model.MamCustomer;


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
	
	public static void main(String[] args) {
		URL configURL = RedisTemplateHelper.class.getResource("/properties/log4j.properties");
		PropertyConfigurator.configure(configURL);
		ApplicationContext ac = new FileSystemXmlApplicationContext(new String[]{
						"classpath*:redis/redis_dev.xml"
				});
		//RedisTemplate<String, Object> redisObjTemplate = (RedisTemplate<String, Object>)ac.getBean("strObjRedisTemplate");
		RedisTemplate<String, Object> redisHashObjTemplate1 = (RedisTemplate<String, Object>)ac.getBean("strHashRedisTemplate");
		String mailKey = "noticeType";
		//设置值
		//redisHashObjTemplate1.opsForValue().set(mailKey, 1);
		System.out.println("curMailNo:key="+mailKey+"|value="+redisHashObjTemplate1.opsForValue().get(mailKey));
		System.out.println("nextMailNo:key="+mailKey+"|value="+genMailNo(redisHashObjTemplate1, mailKey));
		System.out.println("aftergenMailNo, curMailNo:key="+mailKey+"|value="+redisHashObjTemplate1.opsForValue().get(mailKey));
		
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
}
