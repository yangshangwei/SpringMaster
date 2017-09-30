package com.xgj.dao.namedParameterJdbcTemplate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.xgj.dao.namedParameterJdbcTemplate.domain.Artisan;

/**
 * 
 * 
 * @ClassName: ArtisanNJDaoImpl
 * 
 * @Description: @Repository标注的DAO层，受Spring管理
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月30日 上午12:42:26
 */

@Repository
public class ArtisanNJDaoImpl implements ArtisanNJDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private final static String insertArtisanSql = "insert into artisan(artisan_name) values(:artisanName)";

	private final static String selectArtisanByIds = "select artisan_name from artisan where artisan_id in (:artisanId)";

	/**
	 * 
	 * 
	 * @Title: setNamedParameterJdbcTemplate
	 * 
	 * @Description: 自动注入namedParameterJdbcTemplate
	 * 
	 * @param namedParameterJdbcTemplate
	 * 
	 * @return: void
	 */
	@Autowired
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void addArtisan(Artisan artisan) {

		// 定义命名参数
		SqlParameterSource sps = new BeanPropertySqlParameterSource(artisan);
		// 使用模板类方法
		namedParameterJdbcTemplate.update(insertArtisanSql, sps);
	}

	public void addArtisanWithMapSqlParameterSource(Artisan artisan) {

		// 使用MapSqlParameterSource绑定参数
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
				.addValue("artisanName", artisan.getArtisanName());

		// 使用模板类方法
		namedParameterJdbcTemplate.update(insertArtisanSql,
				mapSqlParameterSource);
	}

	public List<Artisan> getArtisanByIds(List<String> artisanIds) {

		final List<Artisan> artisanList = new ArrayList<Artisan>();

		// 使用MapSqlParameterSource绑定参数
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

		mapSqlParameterSource.addValue("artisanId", artisanIds);

		namedParameterJdbcTemplate.query(selectArtisanByIds,
				mapSqlParameterSource, new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						Artisan artisan = new Artisan();
						artisan.setArtisanName(rs.getString("artisan_name"));
						// 加入集合
						artisanList.add(artisan);
					}
				});

		return artisanList;
	}
}
