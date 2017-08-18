package com.xgj.ioc.configuration.lazyLoad;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
// @Lazy 目标Bean 延迟注入
@Component
// 通过注解标注为一个Bean，以便Spring扫描并实例化
public class Plane {

	/**
	 * 
	 * 
	 * @Title:Plane
	 * 
	 * @Description:无参构造函数
	 */
	public Plane() {
		super();
		System.out.println("Plan init ");
	}

	public void fly() {
		System.out.println("Plane begins to  fly");
	}

}
