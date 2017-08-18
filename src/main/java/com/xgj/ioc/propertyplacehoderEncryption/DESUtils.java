package com.xgj.ioc.propertyplacehoderEncryption;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class DESUtils {
	private static Key key;
	// 指定DES加密解密用的密钥
	private static String KEY_STR = "myKey";
	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(KEY_STR.getBytes()));
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * 
	 * @Title: getEncryptString
	 * 
	 * @Description: 对字符串进行加密，返回BASE64编码的加密字符串
	 * 
	 * @param str
	 * @return
	 * 
	 * @return: String
	 */
	public static String getEncryptString(String str) {
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byte[] strBytes = str.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return base64en.encode(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * 
	 * @Title: getDecryptString
	 * 
	 * @Description:对BASE64编码的加密字符串进行解密，返回解密后的字符串
	 * 
	 * @param str
	 * @return
	 * 
	 * @return: String
	 */
	public static String getDecryptString(String str) {
		BASE64Decoder base64De = new BASE64Decoder();
		try {
			byte[] strBytes = base64De.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			return new String(decryptStrBytes, "UTF8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 
	 * 
	 * @Title: main
	 * 
	 * @Description: 测试方法
	 * 
	 * @param args
	 * @throws Exception
	 * 
	 * @return: void
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(getEncryptString("cc"));
		System.out.println(getEncryptString("zsmart2017"));

		System.out.println(getDecryptString("SkR6wWI9iws="));
		System.out.println(getDecryptString("lSR/mscM1NE3sM98QFjAdw=="));
	}
}
