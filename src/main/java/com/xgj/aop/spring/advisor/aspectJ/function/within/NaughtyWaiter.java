package com.xgj.aop.spring.advisor.aspectJ.function.within;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: NaughtyWaiter
 * 
 * @Description: @Component标注的bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月5日 上午1:31:10
 */

@Component
public class NaughtyWaiter implements Waiter {

	@Override
	public void greetTo(String clientName) {
		System.out.println("NaughtyWaiter greetTo " + clientName);
	}

	@Override
	public void serverTo(String clientName) {
		System.out.println("NaughtyWaiter greetTo " + clientName);
	}

}
