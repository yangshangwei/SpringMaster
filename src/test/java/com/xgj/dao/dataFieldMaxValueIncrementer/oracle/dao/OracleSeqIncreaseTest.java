package com.xgj.dao.dataFieldMaxValueIncrementer.oracle.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.dao.dataFieldMaxValueIncrementer.oracle.domain.Artisan;

public class OracleSeqIncreaseTest {

	ClassPathXmlApplicationContext ctx = null;
	AritsanOracleDaoImpl aritsanOracleDaoImpl = null;

	@Before
	public void initContext() {
		// Æô¶¯Spring ÈÝÆ÷
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/dataFieldMaxValueIncrementer/conf_oracleincreaseId.xml");
		aritsanOracleDaoImpl = ctx.getBean("aritsanOracleDaoImpl",
				AritsanOracleDaoImpl.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void queryTeacherById() {
		for (int i = 0; i < 5; i++) {
			Artisan artisan = new Artisan();
			artisan.setArtisanName("Xiao" + i);
			aritsanOracleDaoImpl.addArtisan(artisan);
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
