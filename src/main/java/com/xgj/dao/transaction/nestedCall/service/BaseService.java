package com.xgj.dao.transaction.nestedCall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * 
 * @ClassName: BaseSerivce
 * 
 * @Description: 服务的基类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月24日 下午4:24:20
 */
public abstract class BaseService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
