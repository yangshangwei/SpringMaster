package com.xgj.aop.spring.advisor.schema.advices;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceMethods {
	/**
	 * 
	 * 
	 * @Title: before
	 * 
	 * @Description: 前置增强对应的方法
	 * 
	 * @param name
	 * 
	 * @return: void
	 */
	public void beforeMethod() {
		System.out.println("--Before CrossCuttingCode--");
	}

	/**
	 * 
	 * 
	 * @Title: afterReturning
	 * 
	 * @Description: 后置增强对应方法 ,配置文件中的returing属性必须和增强方法的入参名称一致
	 * 
	 * @param retVal
	 * 
	 * @return: void
	 */
	public void afterReturningMethod(int retVal) {
		System.out.println("----afterReturning() begin----");
		System.out.println("returnValue:" + retVal);
		System.out.println("----afterReturning() end----");
	}

	/**
	 * 
	 * 
	 * @Title: aroundMethod
	 * 
	 * @Description: 环绕增强对应方法
	 * 
	 * @param pjp
	 * 
	 * @return: void
	 * @throws Throwable
	 */
	public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("----aroundMethod() begin----");
		System.out.println("args[0]:" + pjp.getArgs()[0]);
		// 执行目标类的目标方法
		pjp.proceed();
		System.out.println("----aroundMethod() end----");
	}

	/**
	 * 
	 * 
	 * @Title: afterThrowingMethod
	 * 
	 * @Description: 抛出异常增强
	 * 
	 * @param iae
	 * 
	 * @return: void
	 */
	public void afterThrowingMethod(IllegalArgumentException iae) {
		System.out.println("----afterThrowingMethod()----");
		System.out.println("exception msg:" + iae.getMessage());
		System.out.println("----afterThrowingMethod()----");
	}

	/**
	 * 
	 * 
	 * @Title: afterMethod
	 * 
	 * @Description: final增强
	 * 
	 * 
	 * @return: void
	 */
	public void afterMethod() {
		System.out.println("----afterMethod()----");
	}
}
