package com.xgj.aop.spring.advisor.aspectJ.function;

public class SmartSeller implements Seller {

	public int sell(String goods, String clientName) {
		System.out.println("SmartSeller: sell " + goods + " to " + clientName);
		return 2;
	}

	protected void showGoods(String goods) {
		System.out.println("SmartSeller: shows goods " + goods);
	}
}
