package cfca;

import java.util.ArrayList;
import java.util.List;

import com.bill99.rm.skeye.parallel.util.CM;

import cfca.safeguard.api.pay.bean.tx.downstream.TxA00101;
import cfca.safeguard.api.pay.util.Base64;
import xml.XMLHelper;

public class CfcaXmlUtils {
	
	/**
	 * 构建前置机消息报文头
	 * @return
	 */
	public static String makeFrontHeadContent(){
		StringBuilder sb = new StringBuilder(200);
		sb.append("<Head>");
		XMLHelper.appendXmlNode(sb, "Code", "100000");
		XMLHelper.appendXmlNode(sb, "Description", "test");
		sb.append("</Head>");
		return sb.toString();
	}
	
	
	/**
	 * 构建前置机消息报文体
	 * @param strList-下行报文List
	 * @return
	 */
	public static String makeFrontBodyContent(List<String> strList) throws Exception{
		StringBuilder sb = new StringBuilder(200);
		sb.append("<Body>");
		XMLHelper.appendXmlNode(sb, "MessageList", makeMsgListContent(strList));
		sb.append("</Body>");
		return sb.toString();
	}
	
	/**
	 * 构建消息List
	 * @param strList-下行报文List
	 * @return
	 */
	public static String makeMsgListContent(List<String> strList) throws Exception{
		StringBuilder msgList = new StringBuilder(200);
		if(strList!=null && strList.size()>0){
			for(int i=0; i<strList.size(); i++){
				XMLHelper.appendXmlNode(msgList, "Message", new String(base64(strList.get(i)), "UTF-8"));
			}
		}
		return msgList.toString();
	}
	
	
	public static byte[] base64(String str) throws Exception{
		return Base64.encode(str.getBytes("UTF-8"));
	}
	
	
	/**
	 * 构建前置机消息
	 * @return
	 */
	public static String makeFront() throws Exception{
		StringBuilder sb = new StringBuilder(20000);
		sb.append("<Response>");
		sb.append(makeFrontHeadContent());
		String txA00101 = makeTxA00101();
		List<String> strList = new ArrayList<String>();
		strList.add(txA00101);
		sb.append(makeFrontBodyContent(strList));
		sb.append("</Response>");
		return sb.toString();
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println(makeFront());
	}
	
	
	/**
	 * 构建A00101
	 * @return
	 */
	public static String makeTxA00101(){
		TxA00101 txA00101 = new TxA00101();
		StringBuilder sb = new StringBuilder(1000);
		sb.append("<Response>");
		String head = makeTxHeadContent("A00101");
		sb.append(head);
		String body = makeTxA00101BodyContent(txA00101);
		sb.append(body);
		sb.append("</Response>");
		return sb.toString();
	}
	
	
	/**
	 * 构建tx报文头
	 * @param txCode
	 * @return
	 */
	public static String makeTxHeadContent(String txCode){
		StringBuilder sb = new StringBuilder(200);
		sb.append("<Head>");
		XMLHelper.appendXmlNode(sb, "TxCode", txCode);
		XMLHelper.appendXmlNode(sb, "MessageFrom", "100000");
		XMLHelper.appendXmlNode(sb, "TransSerialNumber", "100000");
		sb.append("</Head>");
		return sb.toString();
	}
	
	/**
	 * 构建TxA00101报文体
	 * @param txA00101
	 * @return
	 */
	public static String makeTxA00101BodyContent(TxA00101 txA00101) {
		StringBuilder sb = new StringBuilder();
		//R
		Long serialNoLong = System.currentTimeMillis();
		String serialNoStr = CM.toString(serialNoLong);
		XMLHelper.appendXmlNode(sb, "ApplicationID", serialNoStr);
		XMLHelper.appendXmlNode(sb, "CaseNumber", serialNoStr);
		XMLHelper.appendXmlNode(sb, "CaseType", "0000");
		//O
		XMLHelper.appendXmlNode(sb, "TransferOutBankID", "");
		XMLHelper.appendXmlNode(sb, "TransferOutBankName", "");
		XMLHelper.appendXmlNode(sb, "TransferOutAccountName", "");
		XMLHelper.appendXmlNode(sb, "TransferOutAccountNumber", "");
		XMLHelper.appendXmlNode(sb, "Currency", "");
		XMLHelper.appendXmlNode(sb, "TransferAmount", "");
		XMLHelper.appendXmlNode(sb, "TransferTime", "");
		//R
		XMLHelper.appendXmlNode(sb, "OnlinePayCompanyID", "Z00831000014");
		//O
		XMLHelper.appendXmlNode(sb, "OnlinePayCompanyName", "99bill");
		//C
		XMLHelper.appendXmlNode(sb, "SubjectType", "01");
		//R
		XMLHelper.appendXmlNode(sb, "DataType", "01");
		XMLHelper.appendXmlNode(sb, "Data", "10012201696");
		XMLHelper.appendXmlNode(sb, "Reason", "test");
		//O
		XMLHelper.appendXmlNode(sb, "Remark", "test");
		//R
		XMLHelper.appendXmlNode(sb, "StartTime", "20161221200000");
		XMLHelper.appendXmlNode(sb, "ExpireTime", "20161223200000");
		XMLHelper.appendXmlNode(sb, "ApplicationTime", "20161221200000");
		XMLHelper.appendXmlNode(sb, "ApplicationOrgID", "99bill");
		XMLHelper.appendXmlNode(sb, "ApplicationOrgName", "99bill");
		XMLHelper.appendXmlNode(sb, "OperatorIDType", "IDCARD");
		XMLHelper.appendXmlNode(sb, "OperatorIDNumber", "20161223200000");
		XMLHelper.appendXmlNode(sb, "OperatorName", "test");
		//O
		XMLHelper.appendXmlNode(sb, "OperatorPhoneNumber", "");
		//R
		XMLHelper.appendXmlNode(sb, "InvestigatorIDType", "IDCARD");
		XMLHelper.appendXmlNode(sb, "InvestigatorIDNumber", "IDCARD");
		XMLHelper.appendXmlNode(sb, "InvestigatorName", "IDCARD");
		return sb.toString();
	}
}
