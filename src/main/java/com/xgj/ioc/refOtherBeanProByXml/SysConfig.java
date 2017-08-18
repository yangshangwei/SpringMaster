package com.xgj.ioc.refOtherBeanProByXml;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

public class SysConfig {

	public int sessionTimeout;
	public int maxTabPageNum;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 * 
	 * @Title: initFromDB
	 * 
	 * @Description: 从数据库中初始化sessionTimeout和maxTabPageNum属性
	 * 
	 * 
	 * @return: void
	 */

	public void initFromDB() {
		System.out.println("initFrom DB");
		final List<String> paramList = new ArrayList<String>();
		String sql = " select  value  from TEMP_SYS_CONFIG a where a.code in ('sessionTimeout' ,'maxTabPageNum') ";
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				paramList.add(rs.getString("value"));
			}
		});
		sessionTimeout = Integer.parseInt(paramList.get(0));
		maxTabPageNum = Integer.parseInt(paramList.get(1));
	}
}
