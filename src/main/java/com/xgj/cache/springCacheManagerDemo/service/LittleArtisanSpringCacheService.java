package com.xgj.cache.springCacheManagerDemo.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import com.xgj.cache.springCacheManagerDemo.domain.LittleArtisan;

/**
 * 
 * 
 * @ClassName: LittleArtisanSpringCacheService
 * 
 * @Description: @Service标注的服务层，受Spring管理
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年10月2日 下午5:34:29
 */

@Service
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
	 * @Description: @Cacheable(cacheNames = "littleArtisan")
	 *               使用名为littleArtisan的缓存
	 * 
	 * 
	 * @return
	 * 
	 * @return: LittleArtisan
	 */

	@Cacheable(cacheNames = "littleArtisan")
	public LittleArtisan getArtisan(String artisanName) {
		// 方法内部实现不考虑缓存逻辑，直接实现业务
		System.out.println("查找Artisan：" + artisanName);
		return getFromDB(artisanName);
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
