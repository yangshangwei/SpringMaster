package com.xgj.dao.lob.nativeConn;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * @ClassName: ArtisanDaoImpl
 * 
 * @Description: @Repository标注DAO层
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月28日 下午5:35:06
 */

@Repository
public class ArtisanDaoImpl {

	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 * 
	 * @Title: setJdbcTemplate
	 * 
	 * @Description: 注入JdbcTemplate
	 * 
	 * @param jdbcTemplate
	 * 
	 * @return: void
	 */
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 * 
	 * @Title: getNativeConn
	 * 
	 * @Description: 要想使这个类正确运行，JdbcTemplate模板配置必须调整，具体见conf-getLocalConnObj.xml
	 * 
	 * 
	 * @return: void
	 */
	public OracleConnection getOracleNativeConn() {
		OracleConnection oracleConnection = null;
		try {
			// 使用DataSourceUtils 从JdbcTemplate中获取数据连接
			Connection connection = DataSourceUtils.getConnection(jdbcTemplate
					.getDataSource());
			// 使用模板类的本地JDBC抽取器获取本地连接
			connection = jdbcTemplate.getNativeJdbcExtractor()
					.getNativeConnection(connection);

			// 强制类型转换
			oracleConnection = (OracleConnection) connection;
			// 使用本地对象，调用API完成业务操作(此处省略) 比如使用OracleConnection特殊 API操作lob

		} catch (CannotGetJdbcConnectionException | SQLException e) {
			e.printStackTrace();
		}
		return oracleConnection;
	}
}
