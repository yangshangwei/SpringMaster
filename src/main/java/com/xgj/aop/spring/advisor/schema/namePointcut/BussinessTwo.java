package com.xgj.aop.spring.advisor.schema.namePointcut;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: BussinessTwo
 * 
 * @Description: 使用注解定义的Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月13日 下午5:17:33
 */

@Component
public class BussinessTwo {
	public void program() {
		System.out.println("BussinessOne program executed");
	}

	public void fixBug() {
		System.out.println("BussinessOne fixBug executed");
	}
}
