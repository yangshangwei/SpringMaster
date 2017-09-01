package com.xgj.aop.spring.advisor.aspectJ.function.args;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: ArgsAspectJ
 * 
 * @Description: 该函数接收一个类名，表示目标类方法入参对象是指定类（包含子类）时，切点匹配
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月1日 上午11:36:23
 */

@Aspect
public class ArgsAspect {

	@Before("args(com.xgj.aop.spring.advisor.aspectJ.function.args.User)")
	public void crossCuttingCode() {
		System.out.println("some logic is here ");
	}
}
