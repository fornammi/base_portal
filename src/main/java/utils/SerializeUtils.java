package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

import com.bill99.golden.inf.sso.util.CM;
import com.test.model.MerchantLimit;

/**
 * 序列化工具类
 * @author daniel.fang
 *
 */
public class SerializeUtils {

	/**
	 * 序列化对象
	 * @param obj
	 * @return
	 */
	public static byte[] serializeObj(Object obj){
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try{
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			byte[] byteArr = baos.toByteArray();
			return byteArr;
		}catch(Exception e){
			return null;
		}finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(baos!=null){
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 反序列化
	 * @param byteArr
	 * @return
	 */
	public static Object deserializeObj(byte[] byteArr){
		ObjectInputStream ois = null;
		ByteArrayInputStream bais = null;
		try{
			bais = new ByteArrayInputStream(byteArr);
			ois = new ObjectInputStream(bais);
			Object obj = ois.readObject();
			return obj;
		}catch(Exception e){
			return null;
		}finally{
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bais!=null){
				try {
					bais.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Long iLong = CM.toLongObj("1");
		MerchantLimit tmp = new MerchantLimit();
		tmp.setId(iLong);
		tmp.setUpMerchantId("1");
		tmp.setMinLimit(new BigDecimal(iLong));
		tmp.setMaxLimit(new BigDecimal(iLong + 99L));
		tmp.setCreaterName("nammi"+1);
		//redis hash中Map的key必须为String
		byte[] valArr = SerializeUtils.serializeObj(tmp);
		System.out.println(valArr);
		System.out.println(SerializeUtils.deserializeObj(valArr));
		MerchantLimit out = (MerchantLimit)SerializeUtils.deserializeObj(valArr);
		System.out.println(out.getCreaterName());
	}
	
}
