package io;

import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

import cfca.CfcaXmlUtils;

public class SocketServerTest {
	private static final int PORT = 8919;
	
	
	public static void main(String[] args) {
		//sendMsgToClient();
		cfcaServer();
	}
	
	/**
	 * 模拟cfca前置机
	 */
	private static void cfcaServer(){
		ServerSocket server = null;
		Socket socket = null;
		DataOutputStream dos = null;
		try{
			server = new ServerSocket(8001);
			while(true){
				socket = server.accept();
				dos = new DataOutputStream(socket.getOutputStream());
				String frontMsg = CfcaXmlUtils.makeFront();
				int count = 1;
				while(count<2){
					System.out.println("cfcaServer send msg:"+frontMsg);
					dos.writeBytes(frontMsg);
					dos.flush();
					count++;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * server发消息
	 * socket = server.accept();只能实现Server和一个客户的对话。
	 */
	private static void sendMsgToClient(){
		ServerSocket server = null;
		Socket socket = null;
		DataOutputStream dos = null;
		try{
			server = new ServerSocket(PORT);
			//使用accept()阻塞等待客户请求，有客户请求到来则产生一个Socket对象，并继续执行
			//等待请求,此方法会一直阻塞,直到获得请求才往下走  
			socket = server.accept();
			dos = new DataOutputStream(socket.getOutputStream());
			int count = 1;
			while(count<5){
				Thread.sleep(1000);
				dos.writeUTF(getRandomStr());
				dos.flush();
				count++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * server收消息
	 */
	private static void receiveMsgFromClient(){
		try{
			ServerSocket server = new ServerSocket(PORT);
			Socket socket = server.accept();
			Reader reader = new InputStreamReader(socket.getInputStream());
			char[] charArr = new char[1024];
			int len;
			StringBuilder builder = new StringBuilder();
			while((len=reader.read(charArr)) != -1){
				builder.append(new String(charArr, 0, len));
			}
			System.out.println("Receive from client, message=: " + builder);
			reader.close();
			socket.close();
			server.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	private static String getRandomStr(){
		int idx = (int)(Math.random()*30);
		int x = (int)(Math.random()*200);
		int y = (int)(Math.random()*300);
		int z = (int)(Math.random()*10);
		StringBuffer sb = new StringBuffer();
		sb.append("idx:").append(idx).append("/x:").append(x).append("/y:").append(y).append("/z:").append(z);
		return sb.toString();
	}
}
