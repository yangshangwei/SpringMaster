package com.xgj.aop.spring.advisor.aspectJ.function.attarget;

import org.springframework.stereotype.Component;

@Mark
@Component
public class C1 extends C0 {
	public void methodName() {
		System.out.println("C1 method executed");
	}
}
