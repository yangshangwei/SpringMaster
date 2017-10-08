package com.xgj.quartz.quartzItself.quickDemo;

import java.text.SimpleDateFormat;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * 
 * @ClassName: SimpleJob
 * 
 * @Description: 实现Job接口,定义需要执行的任务。 JobExecutionContext类提供了调度上下文的各种信息。
 *               Job运行时的信息保存在JobDataMap实例中。
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年10月6日 上午11:56:43
 */

public class SimpleJob implements Job {

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		
		System.out.println(" triggered time is " + dateFormat.format(new java.util.Date()));

	}
}
