package com.xgj.ioc.propertyplacehoderEncryption;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 
 * 
 * @ClassName: EncryptPropertyPlaceholderConfigurer
 * 
 * @Description: 继承PropertyPlaceholderConfigurer,重写convertProperty方法，对属性进行解密
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月6日 下午11:01:23
 */
public class EncryptPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	// 对应jdbc.properties中的key
	private String[] encryptPropNames = { "jdbc.username", "jdbc.password" };

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (isEncryptProp(propertyName)) {
			String decryptValue = DESUtils.getDecryptString(propertyValue);
			System.out.println("解密后的字符串:" + decryptValue);
			return decryptValue;
		} else {
			return propertyValue;
		}
	}

	/**
	 * 判断是否是加密的属性
	 * 
	 * @param propertyName
	 * @return
	 */
	private boolean isEncryptProp(String propertyName) {
		for (String encryptPropName : encryptPropNames) {
			if (encryptPropName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}
