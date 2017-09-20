package com.xgj.dao.basicOperation.callProc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CallProcDemoWithSimpleJdbcCallTest {

	ClassPathXmlApplicationContext ctx = null;

	@Before
	public void initContext() {
		// Æô¶¯Spring ÈÝÆ÷
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/basicOperation/basicOperation.xml");
		System.out.println("initContext successfully");
	}

	@Test
	public void testCallProcWithSimpleJdbcCall() {

		ctx.getBean("callProcDemoWithSimpleJdbcCall",
				CallProcDemoWithSimpleJdbcCall.class).getUserCount(1);

		System.out.println("testCallProcWithSimpleJdbcCall successsfully");
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}

}
