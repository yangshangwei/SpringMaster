package com.xgj.aop.spring.advisor.aspectJAdvance.namePoint;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: NaiveWaiter
 * 
 * @Description: @Component注解标注的bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月10日 下午11:55:00
 */

@Component
public class NaiveWaiter {

	public void greetTo(String clientName) {
		System.out.println("NaiveWaiter greetTo " + clientName);
	}

	public void serverTo(String clientName) {
		System.out.println("NaiveWaiter serverTo " + clientName);
	}
}
