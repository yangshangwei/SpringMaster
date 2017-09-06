package com.xgj.aop.spring.advisor.aspectJ.function.thisFun2;

import org.springframework.stereotype.Component;

@Component
public class SmartSeller implements Seller {

	@Override
	public int sell(String goods, String clientName) {
		System.out.println("SmartSeller: sell " + goods + " to " + clientName
				+ "...");
		return 100;
	}

}
