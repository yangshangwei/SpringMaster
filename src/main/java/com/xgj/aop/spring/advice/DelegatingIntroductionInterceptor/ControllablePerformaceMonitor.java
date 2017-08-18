package com.xgj.aop.spring.advice.DelegatingIntroductionInterceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ControllablePerformaceMonitor extends
		DelegatingIntroductionInterceptor implements Monitorable {

	private static final long serialVersionUID = 1L;
	// 定义ThreadLocal类型的变量，用于保存性能监视开关状态。 为了解决单实例线程安全的问题，通过ThreadLocal
	// 让每个线程单独使用一个状态
	private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

	@Override
	public void setMonitorActive(boolean active) {
		MonitorStatusMap.set(active);
	}

	/**
	 * 拦截方法
	 */
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object obj = null;
		// 对于支持新跟那个监视可控代理，通过判断其状态决定是否开启性能监控功能
		// Java5.0的自动拆包功能，get方法返回的Boolean被自动拆包为boolean类型的值
		if (MonitorStatusMap.get() != null && MonitorStatusMap.get()) {
			PerformanceMonitor.begin(mi.getClass().getName() + "."
					+ mi.getMethod().getName());
			obj = super.invoke(mi);
			PerformanceMonitor.end();
		} else {
			obj = super.invoke(mi);
		}
		return obj;
	}

}
