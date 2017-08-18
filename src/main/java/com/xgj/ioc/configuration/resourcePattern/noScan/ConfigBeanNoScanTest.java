package com.xgj.ioc.configuration.resourcePattern.noScan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigBeanNoScanTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/configuration/resourcePattern/resourcePatternBeans.xml");

		PilotNoScan pilot = ctx.getBean("pilotNoScan", PilotNoScan.class);
		pilot.drivePlane();

		PlaneNoScan plane = ctx.getBean("planeNoScan", PlaneNoScan.class);
		plane.setBrand("A380-NoScan");
		plane.setColor("White-NoScan");
		plane.setSpeed(800);

		plane.introduce();

	}
}
