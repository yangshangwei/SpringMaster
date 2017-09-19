package com.xgj.dao.basicOperation.retrieve_select;

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
		artisanRDao.selectArtisanById(1).toString();

	}

}
