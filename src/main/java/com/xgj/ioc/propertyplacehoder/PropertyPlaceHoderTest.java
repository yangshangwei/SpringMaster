package com.xgj.ioc.propertyplacehoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PropertyPlaceHoderTest {

	private final static String MATCH_COUNT_SQL = " SELECT count(*) FROM temp_user  "
			+ " WHERE user_name =? and password=? ";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 * 
	 * @Title: getMatchCount
	 * 
	 * @Description: 根据用户名和密码判断用户是否存在
	 * 
	 * @param username
	 * @param password
	 * 
	 * @return: int
	 */
	public int getMatchCount(String username, String password) {
		return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[] {
				username, password }, Integer.class);
	}

	/**
	 * 
	 * 
	 * @Title: main
	 * 
	 * @Description: 测试
	 * 
	 * @param args
	 * 
	 * @return: void
	 */
	public static void main(String[] args) {
		// 加载Spring配置文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/propertyplacehoder/beans.xml");
		// 获取通过注解标注的Bean
		PropertyPlaceHoderTest propertyPlaceHoderTest = ctx.getBean(
				"propertyPlaceHoderTest", PropertyPlaceHoderTest.class);
		// 调用方法
		int count = propertyPlaceHoderTest.getMatchCount("xgj", "123456");
		System.out.println("匹配的用户数量：" + count);
	}
}
