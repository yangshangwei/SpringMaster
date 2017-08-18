package com.xgj.aop.base.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class clazz) {
		// 设置需要创建的子类的类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		// 通过字节码动态创建子类实例
		return enhancer.create();

	}

	// 拦截父类所有方法的调用
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		// 横切逻辑代码
		PerformanceMonitor.begin(obj.getClass().getName() + "."
				+ method.getName());
		// 业务逻辑，通过代理类调用父类中的方法
		Object result = proxy.invokeSuper(obj, args);
		// 横切逻辑代码
		PerformanceMonitor.end();
		return result;
	}

}
