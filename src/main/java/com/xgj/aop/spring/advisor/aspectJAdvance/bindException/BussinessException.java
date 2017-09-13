package com.xgj.aop.spring.advisor.aspectJAdvance.bindException;

import org.springframework.stereotype.Component;

@Component
public class BussinessException {

	public void dealBussiness(String bussinessName) {
		System.out.println("dealBussiness executed");
		// just a demo code ,in fact it's not cautious
		if (bussinessName != null && "bug".equals(bussinessName))
			throw new IllegalArgumentException("iae Exception");
		else
			throw new RuntimeException("re Exception");
	}
}
