package com.xgj.cache.selfCacheManagerDemo.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.cache.selfCacheManagerDemo.domain.LittleArtisan;

public class LittleArtisanCacheTest {

	ClassPathXmlApplicationContext ctx = null;
	LittleArtisanService littleArtisanService = null;

	@Before
	public void initContext() {
		// 启动Spring 容器
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/cache/selfCacheManagerDemo/conf.xml");
		littleArtisanService = ctx.getBean("littleArtisanService",
				LittleArtisanService.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void testLoadArtisanFromDBAndCache() {

		LittleArtisan littleArtisan = new LittleArtisan();

		// 第一次 从数据库中获取
		littleArtisan = littleArtisanService.getLittleArtisan("artisan");
		System.out.println("artisanDesc:" + littleArtisan.getArtisanDesc());

		// 再此调用，会从Cache中获取
		littleArtisan = littleArtisanService.getLittleArtisan("artisan");
		System.out.println("artisanDesc:" + littleArtisan.getArtisanDesc());

		// 清空缓存，再此读取,会再此从数据库中加载
		littleArtisanService.reload();
		littleArtisan = littleArtisanService.getLittleArtisan("artisan");
		System.out.println("artisanDesc:" + littleArtisan.getArtisanDesc());
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}
}
