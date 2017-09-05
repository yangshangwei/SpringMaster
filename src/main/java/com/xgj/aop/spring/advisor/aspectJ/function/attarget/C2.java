package com.xgj.aop.spring.advisor.aspectJ.function.attarget;

import org.springframework.stereotype.Component;

@Mark
@Component
public class C2 extends C1 {
	public void methodName() {
		System.out.println("C2 method executed");
	}
}
