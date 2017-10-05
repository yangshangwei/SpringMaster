package com.xgj.aop.spring.advice.innerCallAopSolve;

import com.xgj.aop.spring.advice.innerCallAopSolve.innerCallAOPInterceptor.BeanSelfProxyAware;

/**
 * 
 * 
 * @ClassName: NaiveWaiter
 * 
 * @Description: 解决AOP内部调用无法织入的问题，实现自定义的BeanSelfProxyAware接口
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年10月5日 上午1:50:58
 */
public class NaiveWaiter implements BeanSelfProxyAware {

	private NaiveWaiter waiter;

	public void setSelfProxy(Object object) {
		waiter = (NaiveWaiter) object;
	}

	public void serveTo(String name) {
		System.out.println("waiter serving " + name + "...");
		// 必须使用waiter这个代理调用， 如果直接使用greetTo则相当于是this.greetTo的内部调用，无法AOP织入
		waiter.greetTo(name);
	}

	public void greetTo(String name) {
		System.out.println("waiter greet to "+name+"...");
	}



}
