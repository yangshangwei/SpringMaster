package com.xgj.aop.base.cglib;

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
		// 模拟业务逻辑
		System.out.println("模拟删除Topic,topicId=" + topicId);
		try {
			Thread.currentThread().sleep((long) (Math.random() * 1000 * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeForum(int forumId) {
		// 模拟业务逻辑
		System.out.println("模拟删除forum,forumId=" + forumId);
		try {
			Thread.currentThread().sleep((long) (Math.random() * 1000 * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
