package com.xgj.cache.springCacheXmlEhCache.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.cache.springCacheXmlEhCache.domain.LittleArtisan;

public class TestXmlCacheEhcache {
	ClassPathXmlApplicationContext context = null;
	LittleArtisanSpringCacheService service = null;
	LittleArtisan littleArtisan;

	@Before
	public void initContext() {
		// 启动Spring 容器
		context = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/cache/springCacheXmlEhCache/conf_spring_ehcache.xml");
	}

	@Test
	public void testXmlCache() {

		service = context.getBean("littleArtisanSpringCacheService",
				LittleArtisanSpringCacheService.class);
		// 第一次 从数据库加载
		littleArtisan = service.getArtisan("littleArtisan");
		printArtisan();
		// 第二次 从缓存加载
		littleArtisan = service.getArtisan("littleArtisan");
		printArtisan();
		// 清空缓存
		service.reloadArtisan();
		// 再次查询，从数据库加载
		service.getArtisan("littleArtisan");
		printArtisan();
		// 又查询，从缓存加载
		service.getArtisan("littleArtisan");
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
