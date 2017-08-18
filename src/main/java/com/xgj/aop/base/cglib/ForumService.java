package com.xgj.aop.base.cglib;

/**
 * 
 * 
 * @ClassName: ForumService
 * 
 * @Description: ForumService接口
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月12日 下午4:13:31
 */
public interface ForumService {
	/**
	 * 
	 * 
	 * @Title: removeTopic
	 * 
	 * @Description: 根据topicId删除Topic
	 * 
	 * @param topicId
	 * 
	 * @return: void
	 */
	void removeTopic(int topicId);

	/**
	 * 
	 * 
	 * @Title: removeForum
	 * 
	 * @Description: 根据forumId删除Forum
	 * 
	 * @param forumId
	 * 
	 * @return: void
	 */
	void removeForum(int forumId);
}
