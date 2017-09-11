package com.xgj.aop.spring.advisor.aspectJAdvance.namePoint;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * 
 * @ClassName: NamePoint
 * 
 * @Description: 如果希望在其它地方重用一个切点，我们可以通过@Pointcut注解以及切面类方法对切点进行命名
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月10日 下午11:13:45
 */

public class NamePoint {

	/**
	 * 
	 * 
	 * @Title: inPackage
	 * 
	 * @Description: 通过注解方法inPackage()对该切点进行命名，方法可视域
	 *               修饰符为private,表明该命名切点只能在本切面类中使用。
	 * 
	 * 
	 * @return: void
	 */
	@Pointcut("within(com.xgj.aop.spring.advisor.aspectJAdvance.namePoint.*)")
	private void inPackage() {
	};

	/**
	 * 
	 * 
	 * @Title: greetTo
	 * 
	 * @Description: 通过注解方法greetTo()对该切点进行命名，方法可视域
	 *               修饰符为protected,表明该命名切点可以在当前包中的切面 类、子切面类中中使用。
	 * 
	 * 
	 * @return: void
	 */
	@Pointcut("execution(* greetTo(..))")
	protected void greetTo() {
	}

	/**
	 * 
	 * 
	 * @Title: inPkgGreetTo
	 * 
	 * @Description: 引用命名切点定义的切点，本切点也是命名切点， 它对应的可视域为public
	 * 
	 * 
	 * @return: void
	 */
	@Pointcut("inPackage() and greetTo()")
	public void inPkgGreetTo() {
	}

}
