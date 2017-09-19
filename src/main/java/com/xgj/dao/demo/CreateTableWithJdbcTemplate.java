package com.xgj.dao.demo;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 
 * 
 * @ClassName: CreateTableWithJdbcTemplate
 * 
 * @Description: 
 *               使用DriverManagerDataSource()创建一个数据源,该类并没有提供池化连接的机制，每次调用getConnection
 *               ()方法获取新连接时 ，只是简单的创建一个新的连接，比较适合用在单元测试或者简单的独立应用，因为它不需要额外的依赖类。
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月18日 上午11:32:47
 */
public class CreateTableWithJdbcTemplate {

	private static final String createTableSql = "create table artisan_user ("
			+ " user_id    NUMBER not null," + " user_name  VARCHAR2(50),"
			+ " password   VARCHAR2(10)," + " credits    NUMBER,"
			+ " last_visit DATE," + " last_ip    VARCHAR2(20)"
			+ " ) tablespace TAB_CC" + " pctfree 10 initrans 1 maxtrans 255 "
			+ "storage ( initial 64 next 1 minextents 1 maxextents unlimited"
			+ ")";

	@Test
	public void createTableByJdbcTemplate() {
		// 创建数据源
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@172.25.246.11:1521:testbed");
		dataSource.setUsername("cc");
		dataSource.setPassword("zsmart2017");
		// 创建JdbcTemplate
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		// 绑定数据源
		jdbcTemplate.setDataSource(dataSource);
		// 执行SQL
		jdbcTemplate.execute(createTableSql);
	}
}
