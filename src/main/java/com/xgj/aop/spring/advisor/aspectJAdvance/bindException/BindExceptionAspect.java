package com.xgj.aop.spring.advisor.aspectJAdvance.bindException;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: BindReturnValueAspect
 * 
 * @Description: @Aspect标注的切面，
 *               和通过切点函数绑定连接点信息不同，连接点抛出的异常必须使用AfterThrowing注解的throwing成员进行绑定
 * 
 *               (1)处throwing指定的异常名和(2)处入参的异常名相同，这个异常增强只在连接点抛出的异常instanceof
 *               IllegalArgumentException才匹配，增强方法通过iae参数可以访问抛出的异常对象。
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月12日 下午5:47:23
 */

@Aspect
public class BindExceptionAspect {
	// (1)
	@AfterThrowing(value = "target(com.xgj.aop.spring.advisor.aspectJAdvance.bindException.BussinessException)", throwing = "iae")
	public void crossCuttingCode(IllegalArgumentException iae) {// (2)
		System.out.println("----bindException()----");
		System.out.println("exception:" + iae.getMessage());
		System.out.println("----bindException()----");
	}
}
