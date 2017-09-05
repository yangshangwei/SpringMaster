package com.xgj.aop.spring.advisor.aspectJ.function.args.atargs;

import org.springframework.stereotype.Component;

@Component
public class T1 extends T0 {

	/**
	 * 
	 * 
	 * @Title: fun
	 * 
	 * @Description: 目标类方法,旨在这个方法中织入增强逻辑. 当注解标注在T2,方法的入参为T2或者T2的子孙类时,会织入增强
	 * 
	 * @param t
	 * 
	 * @return: void
	 */
	public void fun(T2 t) {
		System.out.println(t.getClass().getName() + " fun executed");
	}
}
