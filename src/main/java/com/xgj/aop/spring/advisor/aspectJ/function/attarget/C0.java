package com.xgj.aop.spring.advisor.aspectJ.function.attarget;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: C0
 * 
 * @Description: @Component 标注的Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月5日 下午1:36:37
 */

@Component
public class C0 {

	public void methodName() {
		System.out.println("C0 method executed");
	}
}
