package com.xgj.spel.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: MyDataSource
 * 
 * @Description: 数据源 @Component标注
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月7日 下午9:26:32
 */

@Component
public class MyDataSource {

	private String driverClass;
	private String url;
	private String username;
	private String password;

	public String getDriverClass() {
		return driverClass;
	}

	/**
	 * 
	 * 
	 * @Title: setDriverClass
	 * 
	 * @Description: @Value注解自动注入属性配置文件中对应属性的值
	 * 
	 * @param driverClass
	 * 
	 * @return: void
	 */
	@Value("${jdbc.driverClassName}")
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getUrl() {
		return url;
	}

	@Value("${jdbc.url}")
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	// @Value("$(jdbc.username)")
	@Value("${jdbc.username}")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	@Value("${jdbc.password}")
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MyDataSource [driverClass=" + driverClass + ", url=" + url + ", username=" + username + ", password=" + password + "]";
	}

}
