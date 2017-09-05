package com.xgj.aop.spring.advisor.aspectJ.function.args.atargs;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: AtArgsAspect
 * 
 * @Description: 标注了@Aspect的切面
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月1日 下午4:21:14
 */

@Aspect
public class AtArgsAspect {

	@Before("@args(com.xgj.aop.spring.advisor.aspectJ.function.args.atargs.Monitor)")
	public void crossCuttingCode() {
		System.out.println("前置增强 横切逻辑织入 some logic is here ");
	}
}
