package com.xgj.aop.spring.advisor.aspectJ.function.args;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArgsAspectTest {

	private ApplicationContext ctx;

	@Test
	public void test() {
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/function/args/conf-args.xml");
		UserService userService = ctx.getBean("userService", UserService.class);
		UserServiceExt userServiceExt = ctx.getBean("userServiceExt",
				UserServiceExt.class);

		User user = new User();
		ArtisanTT artisan = new ArtisanTT();

		// 织入横切逻辑
		userService.addUser(user);
		// 织入横切逻辑
		userService.modifyUser(user);
		// 织入横切逻辑
		userService.delUser(user);

		System.out.println("================================");
		// 入参不是user，因此不会被织入横切逻辑
		userService.addArtisanTT(artisan);
		userService.modifyArtisanTT(artisan);
		userService.delArtisanTT(artisan);

		System.out.println("================================");
		// 入参为user，因此也会被织入横切逻辑
		userServiceExt.addUser(user);
		// 入参为user，因此也会被织入横切逻辑
		userServiceExt.modifyUser(user);
		// 入参为user，因此也会被织入横切逻辑
		userServiceExt.delUser(user);
		System.out.println("================================");

		// 入参不是user，因此不会被织入横切逻辑
		userServiceExt.addArtisanTT(artisan);
		userServiceExt.modifyArtisanTT(artisan);
		userServiceExt.delArtisanTT(artisan);
	}
}
