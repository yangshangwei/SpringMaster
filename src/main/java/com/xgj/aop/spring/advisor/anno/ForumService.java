package com.xgj.aop.spring.advisor.anno;

/**
 * 
 * 
 * @ClassName: ForumService
 * 
 * @Description: 演示使用自定义注解@NeedTestAnnotation
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月23日 下午5:15:18
 */
public class ForumService {

	@NeedTestAnnotation
	public void removeTopicId(int topicId) {
		System.out.println("remove topicId" + topicId);
	}

	@NeedTestAnnotation(true)
	public void removeForumId(int forumId) {
		System.out.println("remove forumId" + forumId);
	}
}
