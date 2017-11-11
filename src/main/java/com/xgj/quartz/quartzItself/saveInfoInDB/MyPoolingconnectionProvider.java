package com.xgj.quartz.quartzItself.saveInfoInDB;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.quartz.utils.ConnectionProvider;

/**
 * 
 * 
 * @ClassName: MyPoolingconnectionProvider
 * 
 * @Description: MyPoolingconnectionProvider数据源连接和quartz.properties配置文件。
 * 
 *               数据源是自己定义的类，实现了quartz自带的ConnectionProvider类，如果不想使用它，
 *               你也可以选择其他数据源，
 *               比如Tomcat的DataSource，Spring的SimpleDriverDataSource等,自行选择.
 * 
 *               DBCP数据源连接池的属性，这里仅仅使用了必须的配置，其他配置也显式设置，也可使用默认值，根据需要执行调整。
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年10月10日 下午9:49:07
 */
public class MyPoolingconnectionProvider implements ConnectionProvider {
	/**
	 * 使用apache dbcp数据源连接池
	 */
	private BasicDataSource datasource = new BasicDataSource();
	private String driverClassName;
	private String url;
	private String username;
	private String password;

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("getConnection");
		return datasource.getConnection();
	}

	@Override
	public void shutdown() throws SQLException {
		System.out.println("connection pool shutdown");
		datasource.close();

	}

	@Override
	public void initialize() throws SQLException {
		try {
			System.out.println("inti connection");
			datasource.setDriverClassName(driverClassName);
			datasource.setUrl(url);
			datasource.setUsername(username);
			datasource.setPassword(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setDatasource(BasicDataSource datasource) {
		this.datasource = datasource;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
