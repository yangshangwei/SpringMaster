package com.xgj.dao.transaction.multiThreadinTrans.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MulitThreadServiceTest {

	ClassPathXmlApplicationContext ctx = null;
	MulitThreadService mulitThreadService = null;

	@Before
	public void initContext() {
		// Æô¶¯Spring ÈÝÆ÷
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/transaction/multiThreadinTrans/conf_multiThreadTx.xml");
		mulitThreadService = ctx.getBean("mulitThreadService",
				MulitThreadService.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void testNestedCallInOneTransaction() {
		mulitThreadService.executeLogic();
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}
}
