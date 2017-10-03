package com.xgj.cache.springCacheAnno.cachePut;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.cache.springCacheAnno.Artisan;

public class ArtisanCachePutServiceTest {

	ClassPathXmlApplicationContext ctx = null;
	ArtisanCachePutService service = null;

	@Before
	public void initContext() {
		// 启动Spring 容器
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/cache/springCacheAnno/conf_spring.xml");
		service = ctx.getBean("artisanCachePutService",
				ArtisanCachePutService.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void testLoadArtisanFromDBAndCache() {

		Artisan artisan = new Artisan();
		// 第一次 从数据库中获取
		artisan = service.getArtisan("littleArtisan");
		printArtisanInfo(artisan);

		// 缓存条件 @CachePut(cacheNames = "littleArtisan", condition =
		// "#artisanName == 'masterArtisan'")
		// @CachePut 总是先执行方法，然后更新缓存值

		// 第一次 从数据库中获取
		artisan = service.getArtisan("masterArtisan");
		printArtisanInfo(artisan);

		// 第二次 查询masterArtisan ，也会执行方法，从DB取
		artisan = service.getArtisan("masterArtisan");
		printArtisanInfo(artisan);

		// 第二次 查询littleArtisan ，也会执行方法，从DB取
		artisan = service.getArtisan("littleArtisan");
		printArtisanInfo(artisan);
	}

	private void printArtisanInfo(Artisan artisan) {
		System.out.println("Id:" + artisan.getArtisanId());
		System.out.println("Name:" + artisan.getArtisanName());
		System.out.println("Desc:" + artisan.getArtisanDesc());
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
