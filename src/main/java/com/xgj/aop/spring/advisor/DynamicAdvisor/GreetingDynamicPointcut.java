package com.xgj.aop.spring.advisor.DynamicAdvisor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {

	public static List<String> specialClientList = new ArrayList<String>();

	static {
		specialClientList.add("XiaoGongJiangOne");
		specialClientList.add("XiaoGongJiangTwo");
	}

	/**
	 * （1）对类进行静态切点检查
	 */
	public ClassFilter getClassFilter() {
		return new ClassFilter() {

			@Override
			public boolean matches(Class<?> clazz) {
				System.out.println("调用getClassFilter()对 类【 " + clazz.getName()
						+ "】做静态检查\n");
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}

	/**
	 * （2）对方法进行静态切点检查
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out
				.println("调用matches(Method method, Class<?> targetClass),对方法【"
						+ targetClass.getName() + "." + method.getName()
						+ "】做静态检查\n");
		return "greetTo".equals(method.getName());
	}

	/**
	 * （3）对方法进行动态切点检查
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		System.out
				.println("调用matches(Method method, Class<?> targetClass, Object... args)对方法【"
						+ targetClass.getName()
						+ "."
						+ method.getName()
						+ "】做动态检查\n");
		String clientName = (String) args[0];
		return specialClientList.contains(clientName);
	}
}
