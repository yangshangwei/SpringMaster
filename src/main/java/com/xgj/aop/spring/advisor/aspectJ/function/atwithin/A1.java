package com.xgj.aop.spring.advisor.aspectJ.function.atwithin;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: A1
 * 
 * @Description: 标注了@Mark2，可以被增强
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月5日 下午6:02:21
 */

@Mark2
@Component
public class A1 extends A0 {
	public void methodName() {
		System.out.println("A1 method executed");
	}
}
