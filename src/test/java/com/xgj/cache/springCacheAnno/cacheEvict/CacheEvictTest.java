package com.xgj.cache.springCacheAnno.cacheEvict;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.cache.springCacheAnno.Artisan;

public class CacheEvictTest {

	ClassPathXmlApplicationContext ctx = null;
	ArtisanSpringCacheEvictService service = null;

	@Before
	public void initContext() {
		// 启动Spring 容器
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/cache/springCacheAnno/conf_spring.xml");
		service = ctx.getBean("artisanSpringCacheEvictService",
				ArtisanSpringCacheEvictService.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void testLoadArtisanFromDBAndCache() {

		Artisan littleArtisan = new Artisan();

		// @Cacheable(cacheNames = "littleArtisan", condition =
		// "#artisanName == 'masterArtisan'")
		// 根据condition 来看，我们只是缓存#artisanName == 'masterArtisan'的记录

		// 第一次 从数据库中获取
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisanInfo(littleArtisan);

		// 第二次 查询masterArtisan ，根据缓存条件，满足，应该从缓存中获取
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisanInfo(littleArtisan);

		// 将littleArtisan从缓存中移除，再此查询masterArtisan
		service.remove("masterArtisan");
		littleArtisan = service.getArtisan("masterArtisan");
		printArtisanInfo(littleArtisan);

		// 再此 查询masterArtisan ，根据缓存条件，满足，应该从缓存中获取
		littleArtisan = service.getArtisan("masterArtisan");
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
