package com.xgj.dao.basicOperation.getSingleValue;

import org.springframework.stereotype.Repository;

import com.xgj.dao.basicOperation.BaseDao;

/**
 * 
 * 
 * @ClassName: GetCountOfArtisanDao
 * 
 * @Description: @Repository 标注的DAO
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月19日 下午12:05:08
 */

@Repository
public class GetCountOfArtisanDao extends BaseDao {

	private final static String COUNTSQL = "select count(1) from artisan_user where user_name = ? ";

	/**
	 * 
	 * 
	 * @Title: getCount
	 * 
	 * @Description: Both queryForInt() and queryForLong() are deprecated since
	 *               version 3.2.2 (correct me if mistake). To fix it, replace
	 *               the code with queryForObject(String, Class).
	 * 
	 *               https://www.mkyong.com/spring/jdbctemplate-queryforint-is-
	 *               deprecated/
	 * 
	 * @return
	 * 
	 * @return: int
	 */
	public boolean getCount(String userName) {
		boolean isExist = false;
		int count = jdbcTemplate.queryForObject(COUNTSQL,
				new Object[] { userName }, Integer.class);

		if (count > 0) {
			isExist = true;
		} else {
			isExist = false;
		}
		return isExist;
	}
}
