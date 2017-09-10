package com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex;

import org.springframework.stereotype.Component;

@Component
public interface IWaiter {

	void greetTo(String clientName);

	void serverTo(String clientName);
}
