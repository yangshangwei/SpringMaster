package com.xgj.aop.spring.advisor.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

/**
 * 
 * 
 * @ClassName: GreetingAdvisor
 * 
 * @Description: 切面类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月18日 下午8:27:52
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

	private static final long serialVersionUID = 1L;

	/**
	 * 重写matches方法,切点方法匹配规则：方法名为greetTo
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass) {

		return "greetTo".equals(method.getName());
	}

	/**
	 * 默认情况下，匹配所有的类，重写getClassFilter，定义匹配规则 切点类型匹配规则，为Waiter的类或者之类
	 */
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}
}
