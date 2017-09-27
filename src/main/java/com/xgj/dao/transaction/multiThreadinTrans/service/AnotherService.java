package com.xgj.dao.transaction.multiThreadinTrans.service;

import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @ClassName: AnotherService
 * 
 * @Description: @Service标注的Bean， 继承抽象基类MulitThreadBaseService
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月26日 下午4:42:05
 */

@Service
public class AnotherService extends MulitThreadBaseService {

	public void doAnotherThing() {
		System.out.println("AnotherService#doAnotherThing executed");
	}

}
