package com.xgj.aop.spring.advisor.aspectJAdvance.bindTypeAnnoObj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: BindTypeAnnoObjectAspect
 * 
 * @Description: @Aspect标注的切面
 * 
 *               (1)通过(2)处查找出m对应Monitor类型的注解， 因而真实的切点表达式为@within
 *               (Monitor)，当增强方法织入目标 连接点时，增强方法通过m入参可以引用到连接点处的注解对象。
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月12日 下午4:27:55
 */

@Aspect
public class BindTypeAnnoObjectAspect {
	// (1)
	@Before("@within(m)")
	public void bindTypeAnno(Monitor m) { // (2)
		System.out.println("----bindTypeAnnoObject()----");
		System.out.println(m.getClass().getName());
		System.out.println("----bindTypeAnnoObject()----");
	}
}
