package com.xgj.cache.springCacheAnno.CompleteDemoWithEhCache.domain;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 123L;
	private String name;
	private double price;

	/**
	 * 
	 * 
	 * @Title:Product
	 * 
	 * @Description:¹¹Ôìº¯Êý
	 * 
	 * @param name
	 * @param price
	 */
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
