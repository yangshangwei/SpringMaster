package com.xgj.cache.springCacheXml.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.cache.springCacheXml.domain.LittleArtisan;

public class TestXmlCache {

	ClassPathXmlApplicationContext context = null;
	LittleArtisanSpringCacheService service = null;
	LittleArtisan littleArtisan;
	@Before
	public void initContext() {
		// 启动Spring 容器
		context = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/cache/springCacheXml/conf_spring.xml");
	}

	@Test
	public void testXmlCache() {
		
		service = context.getBean(
				"littleArtisanSpringCacheService",
				LittleArtisanSpringCacheService.class);
		// 第一次 从数据库加载
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisan();
		// 第二次 从缓存加载
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisan();
		// 清空缓存
		service.reloadArtisan();
		// 再次查询，从数据库加载
		service.getArtisan("masterArtisan");
		printArtisan();
		// 又查询，从缓存加载
		service.getArtisan("masterArtisan");
		printArtisan();
	}

	private void printArtisan() {
		System.out.println(littleArtisan.getArtisanName() + "||"
				+ littleArtisan.getArtisanDesc());
	}

	@After
	public void releaseContext() {

		if (context != null) {
			context.close();
		}
	}
}
