package com.xgj.cache.springCacheAnno.cacheEvict;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.xgj.cache.springCacheAnno.Artisan;

/**
 * 
 * 
 * @ClassName: ArtisanSpringCacheService
 * 
 * @Description: @Service标注的服务层，受Spring管理
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年10月2日 下午5:34:29
 */

@Service
public class ArtisanSpringCacheEvictService {

	// 模糊查询 在参数的值里设置（%），查询sql语句就只是个命名参数
	private static final String selectArtisanSQL = "select artisan_id ,artisan_name ,artisan_desc "
			+ "	from little_artisan "
			+ " where artisan_name like  :artisanName  ";

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 * 
	 * @Title: getArtisan
	 * 
	 * @Description: @Cacheable(cacheNames = "littleArtisan")
	 *               使用名为littleArtisan的缓存，符合#artisanName == 'masterArtisan'才缓存
	 * 
	 * 
	 * @return
	 * 
	 * @return: LittleArtisan
	 */

	@Cacheable(cacheNames = "littleArtisan", condition = "#artisanName == 'masterArtisan'")
	public Artisan getArtisan(String artisanName) {
		// 方法内部实现不考虑缓存逻辑，直接实现业务
		System.out.println("根据ArtisanName查找Artisan：" + artisanName);
		return getFromDB(artisanName);
	}

	/**
	 * 
	 * 
	 * @Title: remove
	 * 
	 * @Description: 清除缓存
	 * 
	 * @param artisnName
	 * 
	 * @return: void
	 */
	@CacheEvict(cacheNames = "littleArtisan")
	public void remove(String artisnName) {
		System.out.println("littleArtisan  cache removed ");
	}

	/**
	 * 
	 * 
	 * @Title: getFromDB
	 * 
	 * @Description: 这里只是为了演示下
	 *               使用NamedParameterJdbcTemplate模糊查询的用法。其实有可能返回的是一个List。
	 * 
	 * @param artisanName
	 * @return
	 * 
	 * @return: Artisan
	 */
	private Artisan getFromDB(String artisanName) {
		System.out.println("getFromDB");
		final Artisan artisan = new Artisan();

		// 使用MapSqlParameterSource绑定参数 ，拼接模糊查询
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
				.addValue("artisanName", "%" + artisanName + "%");

		jdbcTemplate.query(selectArtisanSQL, mapSqlParameterSource,
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						artisan.setArtisanId(rs.getString("artisan_id"));
						artisan.setArtisanName(rs.getString("artisan_name"));
						artisan.setArtisanDesc(rs.getString("artisan_desc"));
					}
				});

		return artisan;
	}

}
