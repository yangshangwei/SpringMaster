package com.xgj.dao.basicOperation.retrieve_select;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArtisanRDaoTest {

	public static void main(String[] args) {
		// 启动Spring 容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/basicOperation/basicOperation.xml");
		// 从容器中获取Bean
		ArtisanRDao artisanRDao = ctx.getBean("artisanRDao", ArtisanRDao.class);
		// 调用目标方法
		// artisanRDao.selectArtisanById(1).toString();

		// 获取多个artisan
		List<Artisan> artisanList = artisanRDao.selectArtisansByIds(1, 5);
		System.out.println("artisanList size:" + artisanList.size());
		for (Artisan artisan : artisanList) {
			System.out.println("username:" + artisan.getUserName()
					+ ",password:" + artisan.getPassword());
		}

		System.out.println("==================RowMapper======================");

		List<Artisan> artisanList2 = artisanRDao
				.selectArtisansByIdsWithRowMapper(1, 5);
		System.out.println("artisanList size:" + artisanList2.size());
		for (Artisan artisan : artisanList2) {
			System.out.println("username:" + artisan.getUserName()
					+ ",password:" + artisan.getPassword());
		}

	}
}
