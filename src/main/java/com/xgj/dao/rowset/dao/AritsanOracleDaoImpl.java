package com.xgj.dao.rowset.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * @ClassName: AritsanOracleDaoImpl
 * 
 * @Description: @Repository标注DAO层，并被Spring管理
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月29日 下午10:41:10
 */

@Repository
public class AritsanOracleDaoImpl implements AritsanOracleDao {

	private JdbcTemplate jdbcTemplate;

	private static final String selectArtisanByIdSql = "select artisan_name from artisan where artisan_id = ?";

	/**
	 * 
	 * 
	 * @Title: setJdbcTemplate
	 * 
	 * @Description: 自动注入JdbcTemplate
	 * 
	 * @param jdbcTemplate
	 * 
	 * @return: void
	 */
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public SqlRowSet selectArtisanById(int artisanId) {

		return jdbcTemplate.queryForRowSet(selectArtisanByIdSql, artisanId);
	}

}
