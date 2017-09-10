package com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex;

import org.springframework.stereotype.Component;

@Component
public class SellerTwo implements ISeller {

	@Override
	public void greetTo(String clientName) {
		System.out.println("SellerTwo greetTo " + clientName);
	}

	@Override
	public void serverTo(String clientName) {
		System.out.println("SellerTwo serverTo " + clientName);

	}

}
