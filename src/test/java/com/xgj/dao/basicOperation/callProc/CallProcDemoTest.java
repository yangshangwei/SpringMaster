package com.xgj.dao.basicOperation.callProc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CallProcDemoTest {
	public static void main(String[] args) {
		// Æô¶¯Spring ÈÝÆ÷
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/basicOperation/basicOperation.xml");

		CallProcDemo callProcDemo = ctx.getBean("callProcDemo",
				CallProcDemo.class);
		callProcDemo.getUserCount("ArtisanBatch0");

	}
}
