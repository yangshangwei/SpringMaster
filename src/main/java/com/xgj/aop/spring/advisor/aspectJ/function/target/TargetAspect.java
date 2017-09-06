package com.xgj.aop.spring.advisor.aspectJ.function.target;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: TargetAspect
 * 
 * @Description: @Aspect标注的切面
 *               target(com.xgj.aop.spring.advisor.aspectJ.function.
 *               target.Class1)等同于
 *               target(com.xgj.aop.spring.advisor.aspectJ.function
 *               .target.Class1+)
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月5日 下午7:53:52
 */

@Aspect
public class TargetAspect {

	@AfterReturning("target(com.xgj.aop.spring.advisor.aspectJ.function.target.BussinessService+)")
	public void crossCuttingCode() {
		System.out.println("some logic is here");
	}
}
