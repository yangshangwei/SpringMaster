package com.xgj.ioc.configuration.resourcePattern.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigBeanTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/configuration/resourcePattern/resourcePatternBeans.xml");

		PilotScan pilot = ctx.getBean("pilotScan", PilotScan.class);
		pilot.drivePlane();

		PlaneScan plane = ctx.getBean("planeScan", PlaneScan.class);
		plane.setBrand("A380");
		plane.setColor("White");
		plane.setSpeed(800);

		plane.introduce();

	}
}
