package sms;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.bill99.seashell.domain.service.notify.mobile.impl.DefaultSMSNotifyRequest;

public class TestSendMsg {
	//短信服务队列
	private final String SMS_QUEUE = "notify.sms.smsQueue";
	
	public static void main(String[] args) {
		//latest
		
		
		/*TestSendMsg sender = new TestSendMsg();
		DefaultSMSNotifyRequest request = sender.prepareRequest();
		sender.send(request);*/
	}
	
	private DefaultSMSNotifyRequest prepareRequest(){
		DefaultSMSNotifyRequest request = new DefaultSMSNotifyRequest();
		// 短信内容接收者，可以调用此方法加入多个接收者
		request.addRecvMobile("18117040610");
		
		// templateId为seashell.notificationtemplate.ID，记录内容为freemarker格式的短信内容模板.
		// 新增模板请发邮件到pmd_inf@99bill.com
		request.setTemplateId(521);
		// 解析freemarker模板用的kv参数(参数名、值根据模板里的变量来设置)，如果模板解析错误，将无法发送短信，服务端将抛弃这次请求
		Map para = new HashMap();
		para.put("name", "zbzhu");
		para.put("idCardNo", "3426011984888888");
		request.setParameters(para);
		//TODO setContent怎么使用
		String msg = "${name}您好!您的身份证${idCardNo}已验证成功！";
		request.setContent(msg);
		return request;
	}
	
	private void send(final DefaultSMSNotifyRequest request){
		getJmsTemplate().send(SMS_QUEUE, new MessageCreator(){
			public Message createMessage(Session session) throws JMSException{
				ObjectMessage objectMessage = session.createObjectMessage(request);
				return objectMessage;
			}
		});
		System.out.println("sending sms complet");
	}
	
	private JmsTemplate getJmsTemplate(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context/sms/context-notify-sms.xml");
		JmsTemplate jmsTemplate = (JmsTemplate)ctx.getBean("jmsTemplate");
		return jmsTemplate;
	}
}
