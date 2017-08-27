package com.xgj.aop.spring.advisor.aspectJ.function.execution;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: ExecutionPublicAspect
 * 
 * @Description: TODO
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月27日 下午1:47:55
 */

@Aspect
public class ExecutionPublicAspect {

	@Before("execution(public * *(..))")
	public void crossCuttingLogic() {
		System.out.println("织入前置增强,横切逻辑code");
	}

}
