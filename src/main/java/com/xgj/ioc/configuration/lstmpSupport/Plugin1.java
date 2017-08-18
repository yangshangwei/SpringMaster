package com.xgj.ioc.configuration.lstmpSupport;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class Plugin1 implements Plugin {
	/**
	 * 
	 * 
	 * @Title:Plugin1
	 * 
	 * @Description:¹¹Ôìº¯Êý
	 */
	public Plugin1() {
		super();
		System.out.println("Pligin1 Init");
	}
}
