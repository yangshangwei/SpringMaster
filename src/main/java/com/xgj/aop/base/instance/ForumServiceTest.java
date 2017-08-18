package com.xgj.aop.base.instance;

public class ForumServiceTest {

	public static void main(String[] args) {
		ForumService forumService = new ForumServiceImpl();
		forumService.removeTopic(1);
		forumService.removeForum(2);
	}

}
