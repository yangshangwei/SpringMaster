package com.xgj.dao.basicOperation.insertUpdateAndDelete;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.xgj.dao.demo.BaseDao;

/**
 * 
 * 
 * @ClassName: ArtisanDao
 * 
 * @Description: @Repository标注的DAO
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月18日 下午4:19:06
 */

@Repository
public class ArtisanDao extends BaseDao {

	private static final String sql = "insert into artisan_user(user_name,password) values(?,?)";

	/**
	 * 
	 * 
	 * @Title: addSingleArtisan
	 * 
	 * @Description: 增加一个Artisan
	 * 
	 * @param artisan
	 * 
	 * @return: void
	 */
	public void addSingleArtisan(Artisan artisan) {
		jdbcTemplate.update(sql, artisan.getUserName(), artisan.getPassword());
		System.out.println("insert successfully");
	}

	/**
	 * 
	 * 
	 * @Title: addBatchArtisan
	 * 
	 * @Description: 批量更新
	 * 
	 * @param artisanList
	 * 
	 * @return: void
	 */
	public void addBatchArtisan(final List<Artisan> artisanList) {

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int index)
					throws SQLException {
				Artisan artisan = artisanList.get(index);
				ps.setString(1, artisan.getUserName());
				ps.setString(2, artisan.getPassword());
			}

			// 指定该批的记录数
			@Override
			public int getBatchSize() {
				return artisanList.size();
			}
		});

		System.out.println("batch insert successfully");
	}

}
