package com.xgj.dao.transaction.multiTxManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MulitTxServiceWitSpecificName {

	// 使用名为forum的事务管理器
	@Transactional("forum")
	public void addForum() {

	}

	// 使用名为topic的事务管理器
	@Transactional("topic")
	public void addTopic() {

	}
}
