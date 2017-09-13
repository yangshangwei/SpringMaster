package com.xgj.aop.spring.advisor.schema.demo;

/**
 * 
 * 
 * @ClassName: AdviceMethods
 * 
 * @Description: 增强方法所在的Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月13日 下午4:38:25
 */

public class AdviceMethods {

	/**
	 * 
	 * 
	 * @Title: crossCutting
	 * 
	 * @Description: 改方法通过配置被用作增强方法
	 * 
	 * 
	 * @return: void
	 */
	public void crossCutting() {
		System.out.println("crossCutting executed");
	}
}
