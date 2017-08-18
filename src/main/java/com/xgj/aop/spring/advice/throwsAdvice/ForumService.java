package com.xgj.aop.spring.advice.throwsAdvice;

public class ForumService {
	public void removeForum() {
		// 进行相应的数据库操作，但这里只为演示抛出异常
		throw new RuntimeException("removeForum:Exception...");
	}

	public void updateForum() {
		// 进行相应的数据库操作，但这里只为演示抛出异常
		throw new RuntimeException("updateForum:Exception...");
	}
}
