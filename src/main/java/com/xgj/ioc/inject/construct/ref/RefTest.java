package com.xgj.ioc.inject.construct.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RefTest  {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/xgj/ioc/inject/construct/ref/police-gun.xml");
		
		Police police = ctx.getBean("police", Police.class);
		
		police.userGun();
	}
	
}
