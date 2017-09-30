package com.xgj.dao.rowset.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class RowSetTest {

	ClassPathXmlApplicationContext ctx = null;
	AritsanOracleDaoImpl aritsanOracleDaoImpl = null;

	@Before
	public void initContext() {
		// 启动Spring 容器
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/rowset/conf_rowset.xml");
		aritsanOracleDaoImpl = ctx.getBean("aritsanOracleDaoImpl",
				AritsanOracleDaoImpl.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void queryTeacherById() {

		SqlRowSet sqlRowSet = aritsanOracleDaoImpl.selectArtisanById(1);

		// 这时，数据连接已经断开
		while (sqlRowSet.next()) {
			System.out.println("artisan_name:"
					+ sqlRowSet.getString("artisan_name"));
		}
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}
}
