package com.xgj.aop.spring.advisor.aspectJ.aspectJByCode;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: PreGreetingAspect
 * 
 * @Description: 切面类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月24日 下午3:21:15
 */

// 通过@Aspect将PreGreetingAspect标注为一个切面
@Aspect
public class PreGreetingAspect {

	// 定义切点和增强类型
	@Before("execution(* greetTo(..))")
	public void beforeGreeting() {// 增强的横切逻辑
		System.out.println("How are you ?");
	}
}
