package com.xgj.dao.transaction.multiTxManager;

import org.springframework.stereotype.Service;

@Service
public class MulitTxServiceWithSelfDefineAnno {

	// 使用名为forum的事务管理器
	@ForumTransactional
	public void addForum() {

	}

	// 使用名为topic的事务管理器
	@TopicTransactional
	public void addTopic() {

	}
}
