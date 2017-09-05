package com.xgj.aop.spring.advisor.aspectJ.function.atwithin2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;

/**
 * 
 * 
 * @ClassName: TestAspect
 * 
 * @Description: 如果标注了@M注解的是一个接口，则所有实现该接口的类并不匹配@within(M) .
 *               假设接口Waiter标注了@Mark注解，
 *               但是它的实现类NaiveWaiter、NaughtyWaiter这些接口实现类灭有标注@Mark,
 *               则@within(com.xgj.Mark) 和
 * @target(com,xgj.Mark)都不匹配NaiveWaiter、NaughtyWaiter。 因为@within()
 * @target() @annotation函数都是针对目标类而言的，而非针对运行时的引用类型而言。 需要特别注意。
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月5日 下午5:23:32
 */
@Aspect
public class TestAspect implements Ordered {

	@Before("@within(com.xgj.aop.spring.advisor.aspectJ.function.atwithin2.Monitorable)")
	public void atWithinTest() {
		System.out.println("some logic is here");
	}

	public int getOrder() {
		return 1;
	}
}
