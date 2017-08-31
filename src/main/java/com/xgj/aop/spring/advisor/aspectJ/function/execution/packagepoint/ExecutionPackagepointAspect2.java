package com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: ExecutionPackagepointAspect2
 * 
 * @Description: `execution(*
 *               com..*Dao.find*(..))`匹配包名前缀为com的任何包下类名后缀为Dao的方法，方法名必须以find为前缀
 * 
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月30日 下午10:38:59
 */

@Aspect
public class ExecutionPackagepointAspect2 {

	@AfterReturning("execution(* com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint..*Service.remove*(..))")
	public void crossCuttingCode() {
		logic();
	}

	public void logic() {
		System.out
				.println("匹配com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint 包及其子孙包下以Service结尾的类的方法，该方法必须以remove开头"
						+ " some logic is here \n");
	}
}
