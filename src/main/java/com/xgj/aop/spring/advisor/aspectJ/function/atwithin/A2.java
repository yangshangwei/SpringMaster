package com.xgj.aop.spring.advisor.aspectJ.function.atwithin;

import org.springframework.stereotype.Component;

@Component
public class A2 extends A1 {

	public void methodName() {
		System.out.println("A2 method executed");
	}
}
