package com.xgj.aop.spring.advisor.aspectJAdvance.bingReturnValue;

import org.springframework.stereotype.Component;

@Component
public class BussinessRet {

	public String dealBussiness() {
		System.out.println("dealBussiness executed");
		return "SUCCESS";
	}
}
