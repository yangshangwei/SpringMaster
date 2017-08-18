package com.xgj.ioc.inject.construct.utilSchema;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UtilSchemaTest {

	static Logger logger = Logger.getLogger(UtilSchemaTest.class);

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/inject/construct/utilSchema/beans.xml");

		PetShop petShop = ctx.getBean("petShop", PetShop.class);

		logger.info("---------------Map--------------------");
		petShop.petsInfo_Map();

		logger.info("---------------List--------------------");
		petShop.petsInfo_List();

		logger.info("---------------Set--------------------");
		petShop.petsInfo_Set();

		logger.info("---------------Properties--------------------");
		petShop.petsInfo_Properties();

	}
}
