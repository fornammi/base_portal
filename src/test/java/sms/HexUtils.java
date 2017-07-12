package sms;

import java.io.ByteArrayOutputStream;

public class HexUtils {
	private static String hexString = "0123456789ABCDEF";
	
	public static String encode(String str){
		byte[] bytes = str.getBytes();
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for(int i=0; i<bytes.length; i++){
			sb.append(hexString.charAt(bytes[i] & 0xf0 >> 4));
			sb.append(hexString.charAt(bytes[i] & 0xf0 >> 0));
		}
		return sb.toString();
	}
	
	public static String decode(String str){
		ByteArrayOutputStream baos = new ByteArrayOutputStream(str.length()/2);
		for(int i=0; i<str.length(); i+=2){
			baos.write((hexString.indexOf(str.charAt(i))<<4) | hexString.indexOf(str.charAt(i+1)));
		}
		return new String(baos.toByteArray());
	}
}
