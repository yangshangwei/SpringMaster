package com.xgj.dao.dataFieldMaxValueIncrementer.oracle.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.stereotype.Repository;

import com.xgj.dao.dataFieldMaxValueIncrementer.oracle.domain.Artisan;

/**
 * 
 * 
 * @ClassName: AritsanOracleDaoImpl
 * 
 * @Description: @Repository标注DAO层，并被Spring管理
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月29日 下午8:39:32
 */

@Repository
public class AritsanOracleDaoImpl implements AritsanOracleDao {

	private JdbcTemplate jdbcTemplate;
	private OracleSequenceMaxValueIncrementer oracleIncre;

	private static final String addArtisanSql = "insert into artisan(artisan_id ,artisan_name) values(?,?)";

	/**
	 * 
	 * 
	 * @Title: setOracleIncre
	 * 
	 * @Description: 自动注入OracleSequenceMaxValueIncrementer
	 * 
	 * @param oracleIncre
	 * 
	 * @return: void
	 */
	@Autowired
	public void setOracleIncre(OracleSequenceMaxValueIncrementer oracleIncre) {
		this.oracleIncre = oracleIncre;
	}

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

	/**
	 * 使用 oracleIncre.nextIntValue() 作为主键自增长
	 */
	@Override
	public void addArtisan(Artisan artisan) {
		jdbcTemplate.update(addArtisanSql, oracleIncre.nextIntValue(),
				artisan.getArtisanName());
		System.out.println("add Artisan successfully");
	}

}
