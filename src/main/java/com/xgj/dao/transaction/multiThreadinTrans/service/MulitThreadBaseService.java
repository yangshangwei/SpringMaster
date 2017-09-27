package com.xgj.dao.transaction.multiThreadinTrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * 
 * @ClassName: MulitThreadBaseService
 * 
 * @Description: 服务的基类 抽象类希望被继承
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月26日 下午4:41:10
 */

public abstract class MulitThreadBaseService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
