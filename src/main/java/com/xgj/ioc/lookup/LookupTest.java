package com.xgj.ioc.lookup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LookupTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/lookup/beans.xml");

		Plane plane = ctx.getBean("magicPilot", MagicPilot.class).getPlane();
		plane.fly();
		System.out.println(ctx.isPrototype("plane"));

		// MagicPilotImpl magicPilotImpl = ctx.getBean("magicPilotImpl",
		// MagicPilotImpl.class);
		// magicPilotImpl.getPlane().fly();
		// System.out.println(ctx.isPrototype("plane"));
	}
}
