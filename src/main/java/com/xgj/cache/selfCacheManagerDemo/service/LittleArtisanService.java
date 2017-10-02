package com.xgj.cache.selfCacheManagerDemo.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import com.xgj.cache.selfCacheManagerDemo.CacheManager;
import com.xgj.cache.selfCacheManagerDemo.domain.LittleArtisan;

/**
 * 
 * 
 * @ClassName: LittleArtisanService
 * 
 * @Description: @Service标注的Service层，受Spring管理
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年10月2日 下午1:55:56
 */

@Service("littleArtisanService")
public class LittleArtisanService {

	private Logger logger = Logger.getLogger(LittleArtisanService.class);

	// 缓存管理器
	private CacheManager<LittleArtisan> cacheManager;

	// JdbcTemplate
	private JdbcTemplate jdbcTemplate;

	private static final String selectArtisanSQL = "select artisan_id ,artisan_name ,artisan_desc from little_artisan where artisan_name = ?";

	/**
	 * 
	 * 
	 * @Title: setJdbcTemplate
	 * 
	 * @Description: 通过@Autowired注入JdbcTemplate
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
	 * @Title:LittleArtisanService
	 * 
	 * @Description:构造函数
	 */
	public LittleArtisanService() {
		// 初始化LittleArtisanService的时候，实例化CacheManager
		cacheManager = new CacheManager<LittleArtisan>();
	}

	public LittleArtisan getLittleArtisan(String artisanName) {
		// 首先从缓存中查找LittleArtisan
		LittleArtisan littleArtisan = cacheManager.getValue(artisanName);
		// 缓存中不存在则从数据库中获取
		if (littleArtisan != null) {
			logger.info("get littleArtisan from Cache...");
			return littleArtisan;
		}
		// 从数据库中获取
		littleArtisan = getFromDB(artisanName);
		logger.info("get littleArtisan from DB...");
		// 如果数据库中存在记录，则将获取的新数据放在缓存中
		if (littleArtisan != null) {
			cacheManager.addOrUpdateCache(artisanName, littleArtisan);
			logger.info("put cache successfully");
		}
		return littleArtisan;
	}

	/**
	 * 
	 * 
	 * @Title: reload
	 * 
	 * @Description: 清除缓存数据,重新加载
	 * 
	 * 
	 * @return: void
	 */
	public void reload() {
		cacheManager.evictCache();
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
