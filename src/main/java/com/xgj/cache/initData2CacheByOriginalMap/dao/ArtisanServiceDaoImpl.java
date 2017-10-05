package com.xgj.cache.initData2CacheByOriginalMap.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.xgj.cache.initData2CacheByOriginalMap.domain.LittleArtisan;

@Repository
public class ArtisanServiceDaoImpl implements ArtisanServiceDao {

	private static final String selectArtisanSQL = "select artisan_id ,artisan_name ,artisan_desc from little_artisan ";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<LittleArtisan> getAllArtisan() {
		return getArtisanFromDB();
	}

	/**
	 * 
	 * 
	 * @Title: getArtisanFromDB
	 * 
	 * @Description: 从数据库中获取LittleArtisan
	 * 
	 * @param artisanName
	 * @return
	 * 
	 * @return: LittleArtisan
	 */
	public List<LittleArtisan> getArtisanFromDB() {

		System.out.println("getAllArtisanFromDB");

		final List<LittleArtisan> artisanList = new ArrayList<LittleArtisan>();

		jdbcTemplate.query(selectArtisanSQL,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {

				LittleArtisan littleArtisan = new LittleArtisan();

						littleArtisan.setArtisanId(rs.getString("artisan_id"));
						littleArtisan.setArtisanName(rs
								.getString("artisan_name"));
						littleArtisan.setArtisanDesc(rs
								.getString("artisan_desc"));

				artisanList.add(littleArtisan);
					}
				});
		return artisanList;
	}

}
