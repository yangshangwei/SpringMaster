package com.xgj.dao.transaction.programTrans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgramTransServiceTest {

	ClassPathXmlApplicationContext ctx = null;

	@Before
	public void initContext() {
		// Æô¶¯Spring ÈÝÆ÷
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/transaction/programTrans/conf_program_transaction.xml");
		System.out.println("initContext successfully");
	}

	@Test
	public void testProgramTransaction() {

		Artisan artisan = ctx.getBean("artisan", Artisan.class);
		artisan.setUserName("trans");
		artisan.setPassword("123");

		ProgramTransService programTransService = ctx.getBean(
				"programTransService", ProgramTransService.class);

		programTransService.operArtisanInTrans(artisan);

		System.out.println("testProgramTransaction successsfully");
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}

}
