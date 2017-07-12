package rtms;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.bill99.rm.skeye.rtms.parallel.bo.Result;
import com.bill99.rm.skeye.rtms.parallel.bo.TxnInfo;
import com.bill99.rm.skeye.rtms.parallel.bo.TxnResultInfo;
import com.bill99.rm.skeye.rtms.parallel.service.RtmsTxnResultService;
import com.bill99.rm.skeye.rtms.parallel.service.RtmsTxnValidateService;

public class RtmsTest {
	public static void main(String[] args){
		URL configURL = RtmsTest.class.getResource("/properties/log4j.properties");
		PropertyConfigurator.configure(configURL);
		
		ApplicationContext ctx = new FileSystemXmlApplicationContext(new String[]{
			"classpath*:/context/parallel/rtms-tradeValidate-client.xml",
			"classpath*:/context/parallel/rtms-tradeResult-client.xml",
			//No bean named 'tibcoConnectionFactoryRM' is defined
			"classpath*:/context/parallel/rm-mdp-factory.xml",
			//java.lang.ClassNotFoundException: ${rm-jms.jndi.connectionFactory}
			"classpath*:/context/common/envPropertyLoader.xml",
		});
		
		RtmsTxnValidateService validateService = (RtmsTxnValidateService)ctx.getBean("rtmsTradeValidateClient");
		TxnInfo txn = new TxnInfo();
		//交易号
		txn.setTradeId(20160513L);
		//接入应用编号
		txn.setAppId("nammi");
		//*功能码
		txn.setFunctionCode(1L);
		//商户会员号
		txn.setMerchantCode("20131223");
		//外部交易号
		txn.setOutTradeNo("20131223");
		//支付金额
		txn.setPayAmount(new BigDecimal(1505));
		//用户会员号
		txn.setMemberCode("10012195256");
		//交易时间
		txn.setTxnTimeStart(new Date());
		//交易渠道类型（10：B扫C 11：直接账户支付  12：实体卡支付  13：线下C扫B 14：线上C扫B 15：会员扫码转账  16：理财申购  17：理财转让  18：转账  19：一卡通退卡）
		txn.setChannelType(11L);
		//*支付方式
		txn.setPayMode(0L);
		//币种
		txn.setCurrencyCode("01");
		//设备号
		txn.setDeviceInfo("");
		//红包金额
		txn.setCouponAmount(0L);
		//安全支付类型
		txn.setSecureType(0L);
		//商户终端号
		txn.setSubTerminalId("NAMMI01");
		//交易发送方IP
		txn.setTxnSendIp("127.0.0.1");
		//支付银行卡ID
		txn.setMemberBankId("622848");
		System.out.println("#####validate begin#####");
		Result result = validateService.tradeValidate(txn);
		System.out.println("#####validate end#####");
		System.out.println("result:resultCode="+result.getResultCode()+",msgInfo="+result.getMsgInfo());
		
		System.out.println("#####update result begin:save txn#####");
		RtmsTxnResultService resultService = (RtmsTxnResultService)ctx.getBean("rtmsTradeResultClient");
		TxnResultInfo txnResult = new TxnResultInfo();
		txnResult.setTradeId(txn.getTradeId());
		txnResult.setStatus(2L);
		resultService.tradeResultProcess(txnResult);
	}
}
