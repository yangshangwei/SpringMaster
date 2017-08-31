package com.xgj.aop.spring.advisor.aspectJ.function.execution.methodParam;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: ExcutionMethodParamAspect
 * 
 * @Description: 切点表达式中的方法入参部分比较复杂，可以使用*和..通配符。 其中 *表示任意参数类型的参数，
 *               而..表示任意类型的参数且参数个数不限。
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月30日 下午11:33:35
 */

@Aspect
public class ExcutionMethodParamAspect {

	@Before("execution(* doSomething(String,int))")
	public void crossCuttingCode() {
		System.out.println("some logic is here ");
	}
}
