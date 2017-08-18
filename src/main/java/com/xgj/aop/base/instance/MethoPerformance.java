package com.xgj.aop.base.instance;

public class MethoPerformance {

	private long beginTime;
	private long endTime;
	private String methodName;

	/**
	 * 
	 * 
	 * @Title:MethoPerformance
	 * 
	 * @Description:构造函数
	 * 
	 * @param methodName
	 */
	public MethoPerformance(String methodName) {
		super();
		this.methodName = methodName;
		this.beginTime = System.currentTimeMillis();
	}

	/**
	 * 
	 * 
	 * @Title: printPerformance
	 * 
	 * @Description: 计算耗时
	 * 
	 * 
	 * @return: void
	 */
	public void printPerformance() {
		endTime = System.currentTimeMillis();
		long cost = endTime - beginTime;
		System.out.println(methodName + " costs " + cost / 1000 + "秒\n");
	}
}
