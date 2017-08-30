package com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint.bean;

public class ForumService {

	public void removeTopic(int topicId) {
		System.out.println("remove topic " + topicId);
	}

	public void removeBlog(int blogId) {
		System.out.println("remove blog " + blogId);
	}
}
