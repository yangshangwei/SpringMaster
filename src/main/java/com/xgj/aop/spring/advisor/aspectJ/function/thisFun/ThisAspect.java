package com.xgj.aop.spring.advisor.aspectJ.function.thisFun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

/**
 * 
 * 
 * @ClassName: ThisAspect
 * 
 * @Description: @Aspectn标注的切面
 * 
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月5日 下午8:50:26
 */

@Aspect
public class ThisAspect implements Ordered {
	// 织入任何运行期对象为ITransportService的Bean中
	@AfterReturning("this(com.xgj.aop.spring.advisor.aspectJ.function.thisFun.ITransportService)")
	public void corssCuttingCode() {
		System.out.println("some logic is here \n ");
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
