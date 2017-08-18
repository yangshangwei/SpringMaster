package com.xgj.aop.base.instance;

public class PerformanceMonitor {
	// 通过一个ThreadLocal保存与调用线程相关的性能监视信息
	private static ThreadLocal<MethoPerformance> performanceLocal = new ThreadLocal<MethoPerformance>();

	/**
	 * 
	 * 
	 * @Title: begin
	 * 
	 * @Description: 启动对某一目标方法的性能监视
	 * 
	 * @param method
	 * 
	 * @return: void
	 */
	public static void begin(String method) {
		System.out.println("begin to monitor:" + method);
		MethoPerformance methoPerformance = new MethoPerformance(method);
		performanceLocal.set(methoPerformance);
	}

	/**
	 * 
	 * 
	 * @Title: end
	 * 
	 * @Description: 输出性能监视结果
	 * 
	 * @param method
	 * 
	 * @return: void
	 */
	public static void end(String method) {
		System.out.println("finish monitor:" + method);

		MethoPerformance methoPerformance = performanceLocal.get();
		// 打印出方法性能监视的结果信息
		methoPerformance.printPerformance();
	}
}
