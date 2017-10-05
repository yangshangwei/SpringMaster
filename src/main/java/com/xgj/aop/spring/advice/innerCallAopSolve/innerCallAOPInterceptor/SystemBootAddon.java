
package com.xgj.aop.spring.advice.innerCallAopSolve.innerCallAOPInterceptor;

import org.springframework.core.Ordered;


public interface SystemBootAddon extends Ordered {

	/**
	 * 在系统就绪后调用的方法
	 */
    void onReady();
}
