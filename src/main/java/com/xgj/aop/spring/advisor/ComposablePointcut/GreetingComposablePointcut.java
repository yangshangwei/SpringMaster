package com.xgj.aop.spring.advisor.ComposablePointcut;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class GreetingComposablePointcut {

	public Pointcut getIntersectionPointcut() {
		// 创建一个复合切点
		ComposablePointcut composablePointcut = new ComposablePointcut();

		// 创建一个流程切点
		Pointcut controlFlowPointcut = new ControlFlowPointcut(
				WaiterDelegate.class, "service");
		// 创建一个方法名切点
		NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
		nameMatchMethodPointcut.addMethodName("greetTo");

		// 将两个切点进行交集操作
		return composablePointcut.intersection(controlFlowPointcut)
				.intersection((Pointcut) nameMatchMethodPointcut);

	}
}
