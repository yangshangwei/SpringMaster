package com.xgj.aop.spring.advisor.schema.advices;

/**
 * 
 * 
 * @ClassName: InterfaceOneImpl
 * 
 * @Description: 演示引介增强用
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月13日 下午8:14:33
 */
public class InterfaceOneImpl implements InterfaceOne {

	@Override
	public void dealAnotherWork() {
		System.out.println("InterfaceOneImpl dealAnotherWork executed ");

	}

}
