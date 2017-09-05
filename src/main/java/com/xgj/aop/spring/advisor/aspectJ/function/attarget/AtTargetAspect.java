package com.xgj.aop.spring.advisor.aspectJ.function.attarget;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: AtTargetAspect
 * 
 * @Description: 标注了@Aspect的切面 环绕增强切面
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月5日 上午11:59:26
 */

@Aspect
public class AtTargetAspect {

	@Around("@target(com.xgj.aop.spring.advisor.aspectJ.function.attarget.Mark)")
	public void crossCuttingCode(ProceedingJoinPoint joinPoint)
			throws Throwable {
		System.out.println("****AtTargetAspect.crossCuttingCode() : "
				+ joinPoint.getSignature().getName()
				+ ": Before Method Execution");
		try {
			joinPoint.proceed();
		} finally {
			// Do Something useful, If you have
		}
		System.out.println("****AtTargetAspect.crossCuttingCode() : "
				+ joinPoint.getSignature().getName()
				+ ": After Method Execution");
	}
}
