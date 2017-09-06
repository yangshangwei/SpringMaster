package com.xgj.aop.spring.advisor.aspectJ.function.thisFun2;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

@Aspect
public class TestAspect implements Ordered {

	@AfterReturning("this(com.xgj.aop.spring.advisor.aspectJ.function.thisFun2.Seller)")
	public void thisTest() {
		System.out.println("thisTest() executed!");
	}

	public int getOrder() {
		return 1;
	}
}
