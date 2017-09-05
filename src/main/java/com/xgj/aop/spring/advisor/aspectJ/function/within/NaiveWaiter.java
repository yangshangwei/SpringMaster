package com.xgj.aop.spring.advisor.aspectJ.function.within;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: NaiveWaiter
 * 
 * @Description: @Component标注的Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月5日 上午1:30:52
 */

@Component
public class NaiveWaiter implements Waiter {

	@Override
	public void greetTo(String clientName) {
		System.out.println("NaiveWaiter greetTo " + clientName);
	}

	@Override
	public void serverTo(String clientName) {
		System.out.println("NaiveWaiter serverTo " + clientName);

	}

}
