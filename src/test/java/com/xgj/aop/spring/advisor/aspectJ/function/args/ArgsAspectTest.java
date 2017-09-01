package com.xgj.aop.spring.advisor.aspectJ.function.args;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArgsAspectTest {

<<<<<<< HEAD
	private ApplicationContext ctx;

	@Test
	public void test() {
		ctx = new ClassPathXmlApplicationContext(
=======
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
>>>>>>> 75ea043d8f4c2269f6e35dff789a3d42a2bdf259
				"classpath:com/xgj/aop/spring/advisor/aspectJ/function/args/conf-args.xml");
		UserService userService = ctx.getBean("userService", UserService.class);
		UserServiceExt userServiceExt = ctx.getBean("userServiceExt",
				UserServiceExt.class);

		User user = new User();
<<<<<<< HEAD
		// 织入横切逻辑
		userService.addUser(user);
		// 织入横切逻辑
		userService.modifyUser(user);
		// 织入横切逻辑
		userService.delUser(user);
		// userServiceExt继承userService，因此也会被织入横切逻辑
		userServiceExt.addUser(user);
		// userServiceExt继承userService，因此也会被织入横切逻辑
		userServiceExt.modifyUser(user);
		// userServiceExt继承userService，因此也会被织入横切逻辑
=======

		userService.addUser(user);
		userService.modifyUser(user);
		userService.delUser(user);

		userServiceExt.addUser(user);
		userServiceExt.modifyUser(user);
>>>>>>> 75ea043d8f4c2269f6e35dff789a3d42a2bdf259
		userServiceExt.delUser(user);
	}
}
