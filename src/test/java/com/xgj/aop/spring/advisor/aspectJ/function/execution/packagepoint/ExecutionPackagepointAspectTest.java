package com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint.bean.ForumService;
import com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint.bean.bean2.UserService;

public class ExecutionPackagepointAspectTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/aop/spring/advisor/aspectJ/function/execution/packagepoint/conf-execution.xml");

		ForumService forumService = (ForumService) ctx.getBean("forumService");
		UserService userService = (UserService) ctx.getBean("userService");

		forumService.removeBlog(100);
		forumService.removeTopic(200);

		userService.addUserInfo("XiaoGongJiang");
		userService.modifyUserInfo("XiaoGongJiang");
		userService.delUserInfo("XiaoGongJiang");

	}
}
