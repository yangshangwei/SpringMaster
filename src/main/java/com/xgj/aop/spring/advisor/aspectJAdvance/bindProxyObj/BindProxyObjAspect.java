package com.xgj.aop.spring.advisor.aspectJAdvance.bindProxyObj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * 
 * @ClassName: BindProxyObjAspect
 * 
 * @Description: 绑定代理对象
 *               使用this()或target()可绑定被代理对象实例，在通过类实例名绑定对象时，还依然具有原来连接点匹配的功能，
 *               只不过类名是通过增强方法中同名入参的类型间接决定罢了
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月12日 下午12:04:44
 */

@Aspect
public class BindProxyObjAspect {
	// (1)处通过②处查找出waiter对应的类型为BussinessLogicService，因而切点表达式
	// 为this(bussinessLogicService)，当增强方法织入目标连接点时，增强方法通过bussinessLogicService
	// 入参可以引用到代理对象的实例。
	@Before("this(bussinessLogicService)")
	public void bindProxyObj(BussinessLogicService bussinessLogicService) { // (2)
		System.out.println("----bindProxyObj()----");
		System.out.println(bussinessLogicService.getClass().getName());
		System.out.println("----bindProxyObj()----");
	}

}
