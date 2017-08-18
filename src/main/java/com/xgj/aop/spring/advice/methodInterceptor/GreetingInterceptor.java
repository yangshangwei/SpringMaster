package com.xgj.aop.spring.advice.methodInterceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {
	/**
	 * 截取目标类方法的执行，并在前后添加横切逻辑
	 * 
	 * @param invocation
	 *            封装了目标方法和入参数组以及目标方法所带的实例对象
	 * @return 代理对象
	 * @throws Throwable
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 获取目标方法的入参
		Object[] args = invocation.getArguments();
		// 在目标方法执行前调用
		String clientName = (String) args[0];
		System.out.println("GreetingInterceptor：How are you!" + clientName);
		// 利用反射机制来调用目标方法
		Object object = invocation.proceed();
		// 在目标方法执行后调用
		System.out.println("GreetingInterceptor: please enjoy youself!");
		return object;
	}

}
