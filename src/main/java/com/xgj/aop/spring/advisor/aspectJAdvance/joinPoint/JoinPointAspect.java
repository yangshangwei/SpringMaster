package com.xgj.aop.spring.advisor.aspectJAdvance.joinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: JoinPointAspect
 * 
 * @Description: @Aspect标注的切面
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月12日 上午1:10:40
 */

@Aspect
public class JoinPointAspect {
	// 环绕增强
	@Around("execution(* dealLogic(..)) && target(com.xgj.aop.spring.advisor.aspectJAdvance.joinPoint.LogicService)")
	public void crossCodeCutting(ProceedingJoinPoint pjp) throws Throwable { // 声明连接点入参
		System.out.println("-------ProceedingJoinPoint begin----------");
		// 访问连接点信息
		System.out.println("arg[0]:" + pjp.getArgs()[0]);
		System.out.println("signature:" + pjp.getTarget().getClass());
		// 通过连接点执行目标对象的方法
		pjp.proceed();
		System.out.println("-------ProceedingJoinPoint end----------");

	}
}
