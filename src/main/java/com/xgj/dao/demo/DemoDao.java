package com.xgj.dao.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * @ClassName: DemoDao
 * 
 * @Description: 仅为演示示例，在Dao中使用JdbcTemplate,继承于一个极其简单的基类BaseDao
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月18日 下午12:18:00
 */

// (1)声明一个DAO
@Repository
public class DemoDao extends BaseDao {

	// private JdbcTemplate jdbcTemplate;
	private ApplicationContext ctx;

	// 注入JdbcTemplate实例
	// @Autowired
	// public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	// this.jdbcTemplate = jdbcTemplate;
	// }

	public void initTable() {
		// 注意：在实际的项目中，如果SQL不是动态组装的，则应将其定义成一个类级的静态final常量
		// 此处仅为方便阅读，所以放在方法内部
		String createTableSql = "create table artisan_user ("
				+ " user_id    NUMBER not null,"
				+ " user_name  VARCHAR2(50),"
				+ " password   VARCHAR2(10),"
				+ " credits    NUMBER,"
				+ " last_visit DATE,"
				+ " last_ip    VARCHAR2(20)"
				+ " ) tablespace TAB_CC"
				+ " pctfree 10 initrans 1 maxtrans 255 "
				+ "storage ( initial 64 next 1 minextents 1 maxextents unlimited"
				+ ")";

		jdbcTemplate.execute(createTableSql);
		System.out.println("create table successfully");
	}

	@Test
	public void test() {
		// 启动Spring 容器
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/demo/demo.xml");
		// 调用目标方法
		ctx.getBean("demoDao", DemoDao.class).initTable();
	}
}
