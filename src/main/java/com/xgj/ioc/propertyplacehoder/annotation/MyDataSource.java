package com.xgj.ioc.propertyplacehoder.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyDataSource {

	private String driveClassName;

	private String url;

	private String userName;

	private String password;

	/**
	 * 
	 * 
	 * @Title: setDriveClassName
	 * 
	 * @Description: 注入jdbc.driverClassName的值 （也可以直接在属性上注入）
	 * 
	 * @param driveClassName
	 * 
	 * @return: void
	 */
	@Value("${jdbc.driverClassName}")
	public void setDriveClassName(String driveClassName) {
		this.driveClassName = driveClassName;
	}

	@Value("${jdbc.url}")
	public void setUrl(String url) {
		this.url = url;
	}

	@Value("${jdbc.username}")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Value("${jdbc.password}")
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * 
	 * @Title: getDriveClassName
	 * 
	 * @Description: 获取driveClassName
	 * 
	 * @return
	 * 
	 * @return: String
	 */
	public String getDriveClassName() {
		System.out.println("getDriveClassName:" + driveClassName);
		return driveClassName;
	}

	public String getUrl() {
		System.out.println("getUrl:" + url);
		return url;
	}

	public String getUserName() {
		System.out.println("getUserName:" + userName);
		return userName;
	}

	public String getPassword() {
		System.out.println("getPassword:" + password);
		return password;
	}

}
