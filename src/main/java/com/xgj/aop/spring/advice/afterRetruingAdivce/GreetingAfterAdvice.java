package com.xgj.aop.spring.advice.afterRetruingAdivce;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class GreetingAfterAdvice implements AfterReturningAdvice {

	/**
	 * 后置增强代码实现，在目标方法执行后调用
	 * 
	 * @param returnValue
	 *            代理返回对象
	 * @param method
	 *            目标对象方法
	 * @param args
	 *            目标对象方法参数
	 * @param target
	 *            目标对象
	 * @throws Throwable
	 */
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {

		System.out.println("please enjoy youself,Sir!");
	}

}
