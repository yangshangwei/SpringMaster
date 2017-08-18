package com.xgj.ioc.configuration.lstmpSupport;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class Plugin2 implements Plugin {
	/**
	 * 
	 * @Title:Plugin2
	 * 
	 * @Description:¹¹Ôìº¯Êý
	 * 
	 * */
	public Plugin2() {
		super();
		System.out.println("Pligin2 Init");
	}

}
