package com.xgj.aop.spring.advisor.introductionAdvisor;

public class ForumService {
	public void removeTopic(int topicId) {
		System.out.println("Ä£ÄâÉ¾³ýTopic¼ÇÂ¼:" + topicId);
		try {
			Thread.currentThread().sleep((long) (Math.random() * 1000 * 20));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public void removeForum(int forumId) {
		System.out.println("Ä£ÄâÉ¾³ýForum¼ÇÂ¼:" + forumId);
		try {
			Thread.currentThread().sleep((long) (Math.random() * 1000 * 20));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
