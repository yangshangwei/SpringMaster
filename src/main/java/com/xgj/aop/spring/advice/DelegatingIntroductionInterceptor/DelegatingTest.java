package com.xgj.aop.spring.advice.DelegatingIntroductionInterceptor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DelegatingTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advice/DelegatingIntroductionInterceptor/conf-advice.xml");
		ForumService forumService = (ForumService) ctx.getBean("forumService");
		forumService.removeForum(10);
		forumService.removeTopic(1022);

		Monitorable moniterable = (Monitorable) forumService;
		moniterable.setMonitorActive(true);
		forumService.removeForum(10);
		forumService.removeTopic(1022);
	}
}
