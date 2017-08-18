package com.xgj.aop.base.instance;

/**
 * 
 * 
 * @ClassName: ForumServiceImpl
 * 
 * @Description: ForumService实现类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月12日 下午4:14:30
 */
public class ForumServiceImpl implements ForumService {

	@Override
	public void removeTopic(int topicId) {
		// 1-（1）开始对removeTopic方法的监控
		PerformanceMonitor
				.begin("com.xgj.aop.base.instance.ForumServiceImpl.removeTopic");

		// 模拟业务逻辑
		System.out.println("模拟删除Topic");
		try {
			Thread.currentThread().sleep((long) (Math.random() * 1000 * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 1-（2）结束对removeTopic方法的监控
		PerformanceMonitor
				.end("com.xgj.aop.base.instance.ForumServiceImpl.removeTopic");
	}

	@Override
	public void removeForum(int forumId) {
		// 2-（1）开始对removeForum法的监控
		PerformanceMonitor
				.begin("com.xgj.aop.base.instance.ForumServiceImpl.removeForum");
		// 模拟业务逻辑
		System.out.println("模拟删除forum");
		try {
			Thread.currentThread().sleep((long) (Math.random() * 1000 * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 2-（2）结束对removeForum法的监控
		PerformanceMonitor
				.end("com.xgj.aop.base.instance.ForumServiceImpl.removeForum");
	}

}
