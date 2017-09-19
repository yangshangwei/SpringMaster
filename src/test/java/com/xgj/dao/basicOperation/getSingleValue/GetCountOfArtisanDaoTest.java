package com.xgj.dao.basicOperation.getSingleValue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetCountOfArtisanDaoTest {

	public static void main(String[] args) {
		// Æô¶¯Spring ÈÝÆ÷
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/basicOperation/basicOperation.xml");

		GetCountOfArtisanDao getCountOfArtisanDao = ctx.getBean(
				"getCountOfArtisanDao", GetCountOfArtisanDao.class);
		boolean isExist = getCountOfArtisanDao.getCount("ArtisanBatch0");
		System.out.println("artisan exists :" + isExist);

	}
}
