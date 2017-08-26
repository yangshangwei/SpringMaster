package com.xgj.aop.spring.advisor.aspectJ.basic;

public class SmartSeller implements Seller {

	@Override
	public void sell(String goods, String clientName) {
		System.out.println("SmartSeller: sell " + goods + " to " + clientName);
	}

}
