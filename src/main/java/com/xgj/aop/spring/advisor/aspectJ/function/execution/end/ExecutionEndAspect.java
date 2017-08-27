package com.xgj.aop.spring.advisor.aspectJ.function.execution.end;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExecutionEndAspect {

	@AfterReturning("execution(* *To(..))")
	public void crossCuttingCode() {
		System.out.println("后置增强横切代码,some logic is here \n ");
	}
}
