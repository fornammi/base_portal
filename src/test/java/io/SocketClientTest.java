package io;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class SocketClientTest {
	
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 8919;
	
	public static void main(String[] args) throws Exception{
		//receiveMsgFromServer();
		cfcaClient();
	}
	
	
	/**
	 * 模拟收取前置机消息
	 * 备注：socket.getInputStream()-->ByteArrayOutputStream-->String
	 */
	private static void cfcaClient() throws Exception{
		Socket socket = null;
		DataInputStream dis = null;
		InputStream is = null;
		byte[] response = "".getBytes();
		BufferedInputStream bis =null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			socket = new Socket(HOST, 8001);
			is = socket.getInputStream();
			byte[] buf = new byte[1024];
			//System.out.println("is.read(buf):"+is.read(buf));
			int n = 0;
			while(-1 != (n=is.read(buf))){
				baos.write(buf, 0, n);
			}
			response = baos.toByteArray();
			System.out.println("receive msg from cfca front, msg:"+new String(response, "UTF-8"));
			baos.close();
			/*response = IOUtil.readLengthValue(is);
			System.out.println("receive msg from cfca front, msg:"+new String(response, "UTF-8"));*/
			/*
			dis = new DataInputStream(is);
			while(true){
				//dis.readByte()与server端的dos.writeBytes匹配
				System.out.println("receive msg:"+dis.readByte());//读取byte数组里的单个byte
			}*/
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//dis.close();
			//is.close();
			socket.close();
		}
	}
	
	public static byte[] readStream(InputStream inStream) throws Exception{
		int count = 0;
		while(count == 0){
			count = inStream.available();
		}
		byte[] b = new byte[count];
		inStream.read(b);
		return b;
	}
	
	
	/**
	 * client收消息
	 */
	private static void receiveMsgFromServer(){
		Socket socket = null;
		DataInputStream dis = null;
		InputStream is = null;
		try{
			socket = new Socket(HOST, PORT);
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			while(true){
				System.out.println("receive msg:"+dis.readUTF());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * client发消息
	 */
	private static void sendMsgToServer(){
		try{
			Socket client = new Socket(HOST, PORT);
			Writer writer = new OutputStreamWriter(client.getOutputStream());
			writer.write("Hello From Client");
			writer.flush();
			writer.close();
			client.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	
	
}
