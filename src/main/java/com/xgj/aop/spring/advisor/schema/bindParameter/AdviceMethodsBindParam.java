package com.xgj.aop.spring.advisor.schema.bindParameter;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: AdviceMethodsBindParam
 * 
 * @Description: 使用注解定义的Bean，同时也是切面类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月13日 下午8:25:13
 */

@Component
public class AdviceMethodsBindParam {

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
	public void crossCutting(String name, int num) {
		System.out.println("----bindJoinPointParams()----");
		System.out.println("name:" + name);
		System.out.println("number:" + num);
		System.out.println("----bindJoinPointParams()----");
	}
}
