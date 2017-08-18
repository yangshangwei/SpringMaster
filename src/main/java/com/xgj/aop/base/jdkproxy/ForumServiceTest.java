package com.xgj.aop.base.jdkproxy;

import java.lang.reflect.Proxy;

public class ForumServiceTest {

	public static void main(String[] args) {
		// 希望被代理的目标业务类
		ForumService target = new ForumServiceImpl();

		// 将目标类业务和横切代码编织到一起
		PerformanceHandler handler = new PerformanceHandler(target);
		// 根据编织了目标业务类逻辑和性能监控横切逻辑的InvocationHandler实例创建代理实例
		ForumService proxy = (ForumService) Proxy.newProxyInstance(target
				.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);

		// 调用代理实例
		proxy.removeTopic(3);
		proxy.removeForum(1);

	}
}
