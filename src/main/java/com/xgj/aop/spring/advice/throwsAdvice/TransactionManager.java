package com.xgj.aop.spring.advice.throwsAdvice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class TransactionManager implements ThrowsAdvice {
	/**
	 * 捕获异常并打印异常名称
	 * 
	 * @param method
	 *            目标对象对应方法
	 * @param args
	 *            方法入参
	 * @param target
	 *            目标对象
	 * @param ex
	 *            运行方法所捕获的异常
	 * @throws Throwable
	 */
	public void afterThrowing(Method method, Object[] args, Object target,
			Exception ex) throws Throwable {
		System.out.println("method:" + method.getName());
		System.out.println("抛出异常：" + ex.getMessage());
		System.out.println("成功回滚事务");
	}
}
