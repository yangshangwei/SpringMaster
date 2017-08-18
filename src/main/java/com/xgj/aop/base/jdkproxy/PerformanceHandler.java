package com.xgj.aop.base.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {

	private Object target;

	/**
	 * 
	 * 
	 * @Title:PerformanceHandler
	 * 
	 * @Description:构造函数， 入参target为业务目标类
	 * 
	 * @param target
	 */
	public PerformanceHandler(Object target) {
		this.target = target;
	}

	// 性能监视的横切代码 + 业务代码
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// 开始监控 入参 方法的全限定名称
		PerformanceMonitor.begin(target.getClass().getName() + "."
				+ method.getName());
		// 通过反射调用业务类的目标方法
		Object object = method.invoke(target, args);
		// 结束监控
		PerformanceMonitor.end();
		return object;
	}
}
