package com.xgj.aop.spring.advisor.schema.demo;

/**
 * 
 * 
 * @ClassName: BussinessTwo
 * 
 * @Description: 普通POJO
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月13日 下午4:38:10
 */

public class BussinessTwo {
	public void program() {
		System.out.println("BussinessOne program executed");
	}

	public void fixBug() {
		System.out.println("BussinessOne fixBug executed");
	}
}
