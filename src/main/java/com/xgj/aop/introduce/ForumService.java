package com.xgj.aop.introduce;

public class ForumService {
	private TransactionManager transManager;
	private PerformanceMonitor pmonitor;
	private TopicDao topicDao;
	private ForumDao forumDao;

	public void removeTopic(int topicId) {
		// 性能监视开始
		pmonitor.start();
		// 事务开始
		transManager.beginTransaction();
		// （1）业务代码
		topicDao.removeTopic(topicId);

		// 事务结束
		transManager.endTransaction();
		// 性能监视结束
		pmonitor.end();
	}

	public void CreateForum(Forum forum) {
		pmonitor.start();
		transManager.beginTransaction();
		// （2）业务代码
		forumDao.create(forum);

		transManager.endTransaction();
		pmonitor.end();
	}
}
