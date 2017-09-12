package com.xgj.aop.spring.advisor.aspectJAdvance.bindJointParameter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: BindJointPointParameterAspect
 * 
 * @Description: @Aspect标注的切面
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月12日 上午1:10:40
 */

@Aspect
public class BindJointPointParameterAspect {
	// ①绑定连接点参数，首先args(name,number,..)根据②处的增强方法入参找到name和number对应的类型，以得到真实的切点表达式：
	// target(com.xgj.aop.spring.advisor.aspectJAdvance.bindJointParameter.LogicBindService)
	// && args(String,int,..)
	// 在该增强方法织入到目标连接点时，增强方法可以通过num和name访问到连接点方法的入参。
	@Before("target(com.xgj.aop.spring.advisor.aspectJAdvance.bindJointParameter.LogicBindService) && args(name,number,..)")
	public void crossCodeCutting(int number, String name) throws Throwable { // ②增强方法接受连接点的参数
		System.out.println("----bindJoinPointParams()----");
		System.out.println("name:" + name);
		System.out.println("number:" + number);
		System.out.println("----bindJoinPointParams()----");
	}
}
