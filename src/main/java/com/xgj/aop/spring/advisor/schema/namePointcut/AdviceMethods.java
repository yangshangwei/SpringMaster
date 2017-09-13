package com.xgj.aop.spring.advisor.schema.namePointcut;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: AdviceMethods
 * 
 * @Description: 使用注解定义的切面类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月13日 下午5:17:41
 */

@Component
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
