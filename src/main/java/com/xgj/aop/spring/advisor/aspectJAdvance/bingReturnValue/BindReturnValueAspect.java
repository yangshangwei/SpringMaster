package com.xgj.aop.spring.advisor.aspectJAdvance.bingReturnValue;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * 
 * @ClassName: BindReturnValueAspect
 * 
 * @Description: @Aspect标注的切面，
 * 
 *               在后置增强中，可以通过returning绑定连接点方法的返回值
 * 
 *               (1)处和(2)处的名字必须相同，此外(2)处retMsg的类型必须和连接点方法的返回值类型匹配
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月12日 下午5:47:23
 */

@Aspect
public class BindReturnValueAspect {
	// (1)
	@AfterReturning(value = "target(com.xgj.aop.spring.advisor.aspectJAdvance.bingReturnValue.BussinessRet)", returning = "retMsg")
	public void crossCuttingCode(String retMsg) {// (2)
		System.out.println("----bindReturnValue----");
		System.out.println("retMsg:" + retMsg);
		System.out.println("----bindReturnValue----");
	}
}
