package com.xgj.aop.spring.advisor.aspectJ.function.annotationFun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: AnnotationTestAspect
 * 
 * @Description: 切面 、 后置增强 ,@annotation表示标注了某个注解的所有方法
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月26日 下午11:23:53
 */

@Aspect
public class AnnotationTestAspect {

	@AfterReturning("@annotation(com.xgj.aop.spring.advisor.aspectJ.function.NeedTest)")
	public void needTest() {
		System.out.println("needTest() executed,some logic is here");
	}

}
