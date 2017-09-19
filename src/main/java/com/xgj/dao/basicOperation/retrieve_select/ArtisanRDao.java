package com.xgj.dao.basicOperation.retrieve_select;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.xgj.dao.demo.BaseDao;

/**
 * 
 * 
 * @ClassName: ArtisanRDao
 * 
 * @Description: @Repository 标注的DAO
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月18日 下午6:14:24
 */

@Repository
public class ArtisanRDao extends BaseDao {

	private static final String sql = "select user_name ,password from artisan_user where user_id = ? ";

	/**
	 * 
	 * 
	 * @Title: selectArtisanById
	 * 
	 * @Description: 取一条数据
	 * 
	 * @param artisanId
	 * @return
	 * 
	 * @return: Artisan
	 */
	public Artisan selectArtisanById(int artisanId) {

		final Artisan artisan = new Artisan();
		// （1）将结果集中的数据抽取到artisan对象中
		jdbcTemplate.query(sql, new Object[] { artisanId },
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						artisan.setUserName(rs.getString("user_name"));
						artisan.setPassword(rs.getString("password"));
					}
				});
		return artisan;
	}

}
