package com.xgj.dao.basicOperation.insertUpdateAndDelete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArtisanDaoTest {

	public static void main(String[] args) {
		// 启动Spring 容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/basicOperation/basicOperation.xml");

		Artisan artisan = ctx.getBean("artisan", Artisan.class);
		artisan.setUserName("Artisan");
		artisan.setPassword("987654");

		ArtisanDao artisanDao = ctx.getBean("artisanDao", ArtisanDao.class);

		// 调用目标方法
		// artisanDao.addSingleArtisan(artisan);

		// 模拟数据
		List<Artisan> artisanList = new ArrayList<Artisan>();

		for (int i = 0; i < 6; i++) {
			Artisan batchArtisan = new Artisan();
			batchArtisan.setUserName("ArtisanBatch" + i);
			batchArtisan.setPassword("00000" + i);
			artisanList.add(batchArtisan);
		}
		artisanDao.addBatchArtisan(artisanList);
	}
}
