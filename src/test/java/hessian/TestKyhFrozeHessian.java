package hessian;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Scanner;

import com.bill99.ifs.fcs.api.service.MemberModifyService;
import com.caucho.hessian.client.HessianProxyFactory;

public class TestKyhFrozeHessian {
	private static final String merchantId = "104110045112012";
	private static final String terminalId = "00002012";
	private static final String customerId = "33150001";
	private static final String externalRefNumber = "1447835990898**18012943323";
	//private static final String pan = "6214830110731162";
	private static final String pan = "6228480030579646610";
	private static final String cardHolderName = "DH";
	private static final String idType = "0";
	//private static final String cardHolderId = "32058219870706111X";
	private static final String cardHolderId = "421127198606021756";
	private static final String expiredDate = "0911";
	private static final String cvv2 = "111";
	private static final String phoneNO = "15021115806";//18012943323
	private static final String responseCode = "00";
	private static final String responseTextMessage = "交易成功";
	
	public static void main(String[] args) {
		//DEV
		String interName = "com.bill99.ifs.fcs.api.service.MemberModifyService";
		String url = "http://192.168.63.145:8087/ifs-fcs/memberModify.hessian?interface="+interName;
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		//factory.setUser("oracle");
		//factory.setPassword("oracle");
		HashMap authRespMap = null;
		HashMap verifyRespMap = null;
		try {
			MemberModifyService memberModifyService = (MemberModifyService)factory.create(MemberModifyService.class, url);
			String appName = "cams";
			String memberCode = "10012195256";
			String status = "5";//2解冻5冻结
			memberModifyService.updateMemberInfoStatus(appName, memberCode, status);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	
	}
}
