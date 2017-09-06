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
 *               target(com.xgj.IBussiness)
 *               ：IBussiness为接口，匹配接口实现类中所有方法，包括未在接口中声明的方法
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月5日 下午7:53:52
 */

@Aspect
public class TargetAspect {

	@AfterReturning("target(com.xgj.aop.spring.advisor.aspectJ.function.target.IBussinessService)")
	public void crossCuttingCode() {
		System.out.println("some logic is here");
	}
}
