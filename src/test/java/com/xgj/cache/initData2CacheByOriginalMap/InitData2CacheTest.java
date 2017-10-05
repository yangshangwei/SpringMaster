package com.xgj.cache.initData2CacheByOriginalMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.cache.initData2CacheByOriginalMap.domain.LittleArtisan;
import com.xgj.cache.initData2CacheByOriginalMap.service.ArtisanService;


public class InitData2CacheTest {

	ClassPathXmlApplicationContext ctx = null;
	ArtisanService service = null;

	@Before
	public void initContext() {
		// 启动Spring 容器
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/cache/initData2CacheByOriginalMap/conf_spring.xml");
		System.out.println("initContext successfully");
	}

	@Test
	public void testInit2Cache() {
		// 从Map中获取保存的缓存数据
		LittleArtisan artisan = ArtisanService.artisanMap.get("littleArtisan");
		System.out.println(artisan.getArtisanId() + "||"
				+ artisan.getArtisanDesc());


	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}
}
