package com.xgj.aop.spring.advisor.ControlFlowAdvisor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		// Êä³öÇÐµã
		System.out.println("Pointcut:" + target.getClass().getName() + "."
				+ method.getName());
		String clientName = (String) args[0];
		System.out.println("How are you " + clientName + " ?");
	}

}
