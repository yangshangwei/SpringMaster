package com.xgj.dao.basicOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDao {

	public JdbcTemplate jdbcTemplate;

	// ×¢ÈëJdbcTemplateÊµÀý
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
