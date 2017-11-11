package com.xgj.quartz.quartzWithSpring.xml;


/**
 * 
 * 
 * @ClassName: MyJob
 * 
 * @Description: 不用继承Quartz的Job接口
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月10日 下午10:17:26
 */
public class MyJob {

	public void execute() {
		System.out.println("Quartz Spring XML 配置 - MyJob");
	}

}
