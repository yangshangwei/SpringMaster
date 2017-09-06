package com.xgj.aop.spring.advisor.aspectJ.function.thisFun2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.Ordered;

@Aspect
public class EnableSellerAspect implements Ordered {
	@DeclareParents(value = "com.xgj.aop.spring.advisor.aspectJ.function.thisFun2.NaiveWaiter", defaultImpl = SmartSeller.class)
	public static Seller seller;

	public int getOrder() {
		return 2;
	}
}
