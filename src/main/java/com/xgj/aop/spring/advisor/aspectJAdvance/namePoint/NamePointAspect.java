package com.xgj.aop.spring.advisor.aspectJAdvance.namePoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: NamePointTest
 * 
 * @Description: 使用@Aspect注解标注的切面，演示命名切点的使用
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月10日 下午11:42:39
 */

@Aspect
public class NamePointAspect {
	/**
	 * 
	 * 
	 * @Title: pkgGreetTo
	 * 
	 * @Description: 引用了NamePoint.inPkgGreetTo()切点
	 * 
	 * 
	 * @return: void
	 */
	@AfterReturning("NamePoint.inPkgGreetTo()")
	public void pkgGreetTo() {
		System.out.println("pkgGreetTo exectued ,some logic is here ");
	}

	/**
	 * 
	 * 
	 * @Title: pkgGreetToNotNaiveWaiter
	 * 
	 * @Description: 在复合运算中使用了命名切点
	 * 
	 * 
	 * @return: void
	 */
	@AfterReturning("!target(com.xgj.aop.spring.advisor.aspectJAdvance.namePoint.NaiveWaiter) && NamePoint.inPkgGreetTo()")
	public void pkgGreetToNotNaiveWaiter() {
		System.out
				.println("pkgGreetToNotNaiveWaiter() executed,some logic is here");
	}
}
