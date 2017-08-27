package com.xgj.aop.spring.advisor.aspectJ.function.execution;

public class SmartSeller {

	/**
	 * public方法，演示execution(public * *(..)),能匹配到
	 */
	public void sell(String goods) {
		System.out.println("SmartSeller sells " + goods);
	}

	/**
	 * 
	 * 
	 * @Title: smileTo
	 * 
	 * @Description: 非public方法，演示execution(public * *(..))，不能匹配到
	 * 
	 * @param clientName
	 * 
	 * @return: void
	 */
	protected void smileTo(String clientName) {
		System.out.println("SmartSeller simles to " + clientName);
	}

}
