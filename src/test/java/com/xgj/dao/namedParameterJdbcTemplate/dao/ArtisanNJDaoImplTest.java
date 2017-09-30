package com.xgj.dao.namedParameterJdbcTemplate.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.dao.namedParameterJdbcTemplate.domain.Artisan;

public class ArtisanNJDaoImplTest {

	ClassPathXmlApplicationContext ctx = null;
	ArtisanNJDaoImpl artisanNJDaoImpl = null;

	@Before
	public void initContext() {
		// Æô¶¯Spring ÈÝÆ÷
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/namedParameterJdbcTemplate/conf_namedParameterJdbcTemplate.xml");
		artisanNJDaoImpl = ctx.getBean("artisanNJDaoImpl",
				ArtisanNJDaoImpl.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void queryTeacherById() {
		// Artisan artisan = new Artisan();
		// artisan.setArtisanName("ArtisanNJ");
		// artisanNJDaoImpl.addArtisan(artisan);

		// Artisan artisan = new Artisan();
		// artisan.setArtisanName("ArtisanMS");
		// artisanNJDaoImpl.addArtisanWithMapSqlParameterSource(artisan);

		List<String> artisanIds = new ArrayList<String>();
		artisanIds.add("1");
		artisanIds.add("3");
		artisanIds.add("5");
		List<Artisan> artisans = artisanNJDaoImpl.getArtisanByIds(artisanIds);
		for (Artisan artisan : artisans) {
			System.out.println("artisanName:" + artisan.getArtisanName());
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
