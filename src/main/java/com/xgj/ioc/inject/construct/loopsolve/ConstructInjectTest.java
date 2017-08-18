package com.xgj.ioc.inject.construct.loopsolve;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructInjectTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/xgj/ioc/inject/construct/loopsolve/beans.xml");
		
		Pilot pilot = ctx.getBean("pilot", Pilot.class);
//      在xml中注入，或者获取实例化的数据后，代码中set		
//		Plane plane = ctx.getBean("plane", Plane.class);
//		
//		pilot.setPilotNname("XGJ");
//		pilot.setPlane(plane);
//		
//		plane.setPlaneBrand("F35");
//		plane.setPilot(pilot);
		
		pilot.drivePlane();
	}

}
