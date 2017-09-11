package com.xgj.aop.spring.advisor.aspectJAdvance.pointOrder;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

/**
 * 
 * 
 * @ClassName: PointOrderOneAspect
 * 
 * @Description: @Aspect标注的切面,实现Ordered接口 重写getOrder方法 后者 使用注解 @Order(value = 1)
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月11日 上午1:35:42
 */

@Aspect
@Order(value = 1)
public class PointOrderOneAspect {

	@Before("execution(* dealBussiness(..))")
	public void method1() {
		System.out.println("method1 executed");
	}

	@Before("execution(* dealBussiness(..))")
	public void method2() {
		System.out.println("method2 executed");
	}

	@Before("execution(* dealBussiness(..))")
	public void method3() {
		System.out.println("method3 executed");
	}

}
