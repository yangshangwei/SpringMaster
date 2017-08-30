package com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: ExecutionPackagepointAspect
 * 
 * @Description: 类名模式串中, .*表示包下的类 ..*表示包、子孙包下的所有类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月29日 下午12:06:55
 */

@Aspect
public class ExecutionPackagepointAspect {

	@AfterReturning("execution(* com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint.bean..*(..))")
	public void crossCuttingCode() {
		logic();
	}

	public void logic() {
		System.out.println("some logic is here \n");
	}
}
