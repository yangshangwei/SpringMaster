package com.xgj.quartz.quartzWithSpring.anno;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyAnnoJob {

	@Scheduled(cron = "*/5 * * * * ?")
	// 每隔5秒执行一次
	public void test() throws Exception {
		System.out.println("Spring集成Quartz 使用 Annotation的方式......");
	}
}
