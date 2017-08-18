package com.xgj.aop.spring.advice.throwsAdvice;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThrowsAdviceTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advice/throwsAdvice/conf-advice.xml");
		ForumService forumService = ctx.getBean("forumService",
				ForumService.class);
		try {
			forumService.removeForum();
		} catch (Exception e) {
		}
		try {
			forumService.updateForum();
		} catch (Exception e) {
		}
	}
}
