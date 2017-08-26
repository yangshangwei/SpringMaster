package com.xgj.aop.spring.advisor.aspectJ.basic;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 
 * 
 * @ClassName: EnableSellerAspect
 * 
 * @Description: 希望Waiter也能同时充当Seller的角色
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月26日 上午1:23:41
 */

@Aspect
public class EnableSellerAspect {
	// (1)value 为NaiveWaiter添加接口实现, (2)defaultImpl默认的接口实现类
	@DeclareParents(value = "com.xgj.aop.spring.advisor.aspectJ.basic.NaiveWaiter", defaultImpl = SmartSeller.class)
	public Seller seller; // (3) 要实现的目标接口
}
