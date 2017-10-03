package com.xgj.cache.springCacheAnno.cacheable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.cache.springCacheAnno.Artisan;

public class CacheableTest {

	ClassPathXmlApplicationContext ctx = null;
	ArtisanSpringCacheService service = null;

	@Before
	public void initContext() {
		// 启动Spring 容器
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/cache/springCacheAnno/conf_spring.xml");
		service = ctx.getBean("artisanSpringCacheService",
				ArtisanSpringCacheService.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void testLoadArtisanFromDBAndCache() {

		Artisan littleArtisan = new Artisan();
		// 第一次 从数据库中获取
		littleArtisan = service.getArtisan("littleArtisan");
		printArtisanInfo(littleArtisan);

		// @Cacheable(cacheNames = "littleArtisan", condition =
		// "#artisanName == 'masterArtisan'")
		// 根据condition 来看，我们只是缓存#artisanName == 'masterArtisan'的记录

		// 第一次 从数据库中获取
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisanInfo(littleArtisan);

		// 第二次 查询masterArtisan ，根据缓存条件，满足，应该从缓存中获取
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisanInfo(littleArtisan);

		// 第二次 查询littleArtisan ，根据缓存条件，不满足，应该从数据库中获取
		littleArtisan = service.getArtisan("littleArtisan");
		printArtisanInfo(littleArtisan);
	}

	private void printArtisanInfo(Artisan littleArtisan) {
		System.out.println("Id:" + littleArtisan.getArtisanId());
		System.out.println("Name:" + littleArtisan.getArtisanName());
		System.out.println("Desc:" + littleArtisan.getArtisanDesc());
		System.out.println();
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}

}
