package com.xgj.aop.spring.advisor.aspectJAdvance.pointcutComplex;

import org.springframework.stereotype.Component;

@Component
public interface ISeller {

	void greetTo(String clientName);

	void serverTo(String clientName);
}
