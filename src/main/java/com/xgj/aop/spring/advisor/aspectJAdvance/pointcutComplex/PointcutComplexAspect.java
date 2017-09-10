package com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: PointcutComplexAspect
 * 
 * @Description: 标注了@Aspect的切面
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月9日 上午1:50:45
 */

@Aspect
public class PointcutComplexAspect {

	/**
	 * 
	 * 
	 * @Title: matchGreetTo
	 * 
	 * @Description: 与预算,匹配com.xgj.aop.spring.advisor.aspectJAdvance.
	 *               pointcutComplex包中所有greetTo()方法的切点
	 * 
	 * 
	 * @return: void
	 */
	@Before("within(com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex.*)"
			+ " && execution(* greetTo(..))")
	public void matchGreetTo() {
		System.out.println("matchGreetTo executed,some logic is here ");
	}

	/**
	 * 
	 * 
	 * @Title: something
	 * 
	 * @Description: 非与预算，匹配所有的serverTo方法,且不位于WaiterOne目标类切点
	 * 
	 * 
	 * @return: void
	 */

	@After("!target(com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex.WaiterOne)"
			+ " && execution(* serverTo(..))")
	public void something() {
		System.out.println("something executed,some logic is here ");
	}

	/**
	 * 
	 * 
	 * @Title: method
	 * 
	 * @Description: 或运算，匹配IWaiter和ISeller接口实现类所有连接点的切点
	 * 
	 * 
	 * @return: void
	 */

	@AfterReturning("target(com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex.IWaiter)"
			+ " || target(com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex.ISeller)")
	public void method() {
		System.out.println("method executed,some logic is here ");
	}

}
