package com.xgj.aop.spring.advisor.introductionAdvisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntroductionAdvisorTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/introductionAdvisor/conf-introductionAdvisor.xml");

		ForumService forumService = (ForumService) ctx.getBean("forumService");
		forumService.removeForum(10);
		forumService.removeTopic(1022);

		Monitorable moniterable = (Monitorable) forumService;
		moniterable.setMonitorActive(true);
		forumService.removeForum(10);
		forumService.removeTopic(1022);
	}
}
