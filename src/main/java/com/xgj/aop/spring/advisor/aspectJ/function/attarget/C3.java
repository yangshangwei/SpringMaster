package com.xgj.aop.spring.advisor.aspectJ.function.attarget;

import org.springframework.stereotype.Component;

@Component
public class C3 extends C2 {
	public void methodName() {
		System.out.println("C3 method executed");
	}
}
