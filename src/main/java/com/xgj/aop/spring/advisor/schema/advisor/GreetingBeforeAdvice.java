package com.xgj.aop.spring.advisor.schema.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 
 * 
 * @ClassName: GreetingBeforeAdvice
 * 
 * @Description: 前置增强
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月13日 下午8:55:12
 */

public class GreetingBeforeAdvice implements MethodBeforeAdvice {

	/**
	 * 前置增强方法 当该方法发生异常时，将阻止目标方法的执行
	 * 
	 * @param method
	 *            目标类方法
	 * @param objects
	 *            目标类方法入参
	 * @param target
	 *            目标类对象实例
	 * @throws Throwable
	 */
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		String clientName = (String) args[0];
		System.out.println("How are you " + clientName + " ?");
	}
}
