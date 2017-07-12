package sms;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpStatus;

import com.alibaba.fastjson.JSON;

public class SendSms {
	
	private static final String url = "http://192.168.15.132:8083/sms-prepare/sendSms.do";
	//private static final String url = "http://sms-gateway.99bill.com/sms-prepare/sendSms.do";
	
	public static void send(){
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(url);
		Map<String, String> map = new HashMap<String, String>();
		map.put("mobile", "18117040610");//多个手机号用逗号分隔
		map.put("channel", "1");//默认为1：通知类短信
		map.put("templateId", "");//架构组审批的模板ID
		//以下为模板中的参数
		map.put("", "");
		
		//com.alibaba fastjson.jar
		String jsonMap = JSON.toJSONString(map);
		String s = HexUtils.encode(jsonMap);
		post.addParameter(new NameValuePair("parameters", s));
		String responseContent = null;
		InputStream is = null;
		try{
			int statusCode = client.executeMethod(post);
			if(statusCode == HttpStatus.SC_OK){
				is = post.getResponseBodyAsStream();
				String response = post.getResponseBodyAsString();
				System.out.println(response);
			}
		}catch(HttpException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			((SimpleHttpConnectionManager)client.getHttpConnectionManager()).shutdown();
		}
	}
}
