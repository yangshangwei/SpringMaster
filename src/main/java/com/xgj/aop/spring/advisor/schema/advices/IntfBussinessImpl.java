package com.xgj.aop.spring.advisor.schema.advices;

/**
 * 
 * 
 * @ClassName: IntfBussinessImpl
 * 
 * @Description: 演示引介增强用
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月13日 下午8:14:49
 */
public class IntfBussinessImpl implements IntfBussiness {

	@Override
	public void fixBug() {
		System.out.println("IntfBussinessImpl  fixBug executed");
	}

}
