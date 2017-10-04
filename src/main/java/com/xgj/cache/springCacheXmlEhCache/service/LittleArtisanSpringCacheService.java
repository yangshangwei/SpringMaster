package com.xgj.cache.springCacheXmlEhCache.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.xgj.cache.springCacheXmlEhCache.domain.LittleArtisan;

/**
 * 
 * 
 * @ClassName: LittleArtisanSpringCacheService
 * 
 * @Description:
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年10月4日 上午12:41:32
 */


public class LittleArtisanSpringCacheService {
	private Logger logger = Logger
			.getLogger(LittleArtisanSpringCacheService.class);

	private static final String selectArtisanSQL = "select artisan_id ,artisan_name ,artisan_desc from little_artisan where artisan_name = ?";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 * 
	 * @Title: getArtisan
	 * 
	 * @Description: getArtisan 通过在xml中配置 缓存数据
	 * 
	 * @param artisanName
	 * @return
	 * 
	 * @return: LittleArtisan
	 */
	public LittleArtisan getArtisan(String artisanName) {
		// 方法内部实现不考虑缓存逻辑，直接实现业务
		System.out.println("查找Artisan：" + artisanName);
		return getFromDB(artisanName);
	}

	/**
	 * 
	 * 
	 * @Title: reloadArtisan
	 * 
	 * @Description: 清除缓存
	 * 
	 * 
	 * @return: void
	 */
	public void reloadArtisan() {
		System.out.println("cache cleared");
	}

	/**
	 * 
	 * 
	 * @Title: getFromDB
	 * 
	 * @Description: 从数据库中获取LittleArtisan
	 * 
	 * @param artisanName
	 * @return
	 * 
	 * @return: LittleArtisan
	 */
	private LittleArtisan getFromDB(String artisanName) {
		System.out.println("getFromDB");
		final LittleArtisan littleArtisan = new LittleArtisan();

		jdbcTemplate.query(selectArtisanSQL, new Object[] { artisanName },
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						littleArtisan.setArtisanId(rs.getString("artisan_id"));
						littleArtisan.setArtisanName(rs
								.getString("artisan_name"));
						littleArtisan.setArtisanDesc(rs
								.getString("artisan_desc"));
					}
				});
		return littleArtisan;
	}
}
