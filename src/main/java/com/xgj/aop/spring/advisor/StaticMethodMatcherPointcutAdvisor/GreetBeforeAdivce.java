package com.xgj.aop.spring.advisor.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 
 * 
 * @ClassName: GreetBeforeAdivce
 * 
 * @Description: 前置增强
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月18日 下午8:27:40
 */
public class GreetBeforeAdivce implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		// 输出切点
		System.out.println("Pointcut:" + target.getClass().getName() + "."
				+ method.getName());
		String clientName = (String) args[0];
		System.out.println("How are you " + clientName + " ?");
	}
}
