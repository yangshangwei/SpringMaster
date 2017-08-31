package com.xgj.aop.spring.advisor.aspectJ.function.execution.methodParam;

/**
 * 
 * 
 * @ClassName: Farmer
 * 
 * @Description:
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月30日 下午11:31:20
 */
public class Worker {

	public void doSomething(String work, int time) {
		System.out.println("Worker do someThing ,and it costs " + time
				+ " minutes");
	}
}
