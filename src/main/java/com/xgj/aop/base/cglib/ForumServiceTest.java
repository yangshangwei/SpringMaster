package com.xgj.aop.base.cglib;

public class ForumServiceTest {

	public static void main(String[] args) {

		CglibProxy cglibProxy = new CglibProxy();
		// 通过动态生成子类的方式创建代理类
		ForumServiceImpl forumService = (ForumServiceImpl) cglibProxy
				.getProxy(ForumServiceImpl.class);
		// 调用代理类的业务方法
		forumService.removeTopic(1);
		forumService.removeForum(2);
	}
}
