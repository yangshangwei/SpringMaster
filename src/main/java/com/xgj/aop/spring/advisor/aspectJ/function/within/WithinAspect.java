package com.xgj.aop.spring.advisor.aspectJ.function.within;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: WithinAspect
 * 
 * @Description: 标注了@Aspect的切面
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月5日 上午1:21:17
 */

@Aspect
public class WithinAspect {

	// 匹配任何目标类NaiveWaiter的所有方法
	// @AfterReturning("within(com.xgj.aop.spring.advisor.aspectJ.function.within.NaiveWaiter)")
	// public void crossCuttingCode() {
	// System.out.println("后置增强 some logic is here\n");
	// }

	// 不会匹配任何目标类的任何方法
	// @AfterReturning("within(com.xgj.aop.spring.advisor.aspectJ.function.within.Waiter)")
	// public void crossCuttingCode() {
	// System.out.println("后置增强 some logic is here\n");
	// }

	// 匹配com.xgj.aop.spring.advisor.aspectJ.function.within包下的所有类的所有方法，不包括子孙包
	// @AfterReturning("within(com.xgj.aop.spring.advisor.aspectJ.function.within.*)")
	// public void crossCuttingCode() {
	// System.out.println("后置增强 some logic is here\n");
	// }

	// 匹配com.xgj.aop.spring.advisor.aspectJ.function.within包下的所有类的所有方法，包括子孙包
	// @AfterReturning("within(com.xgj.aop.spring.advisor.aspectJ.function.within..*)")
	// public void crossCuttingCode() {
	// System.out.println("后置增强 some logic is here\n");
	// }

	@AfterReturning("within(@com.xgj.aop.spring.advisor.aspectJ.function.within.Mart *)")
	public void crossCuttingCode() {
		System.out.println("后置增强 some logic is here\n");
	}

}
