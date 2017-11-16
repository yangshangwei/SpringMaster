package com.xgj.quartz.quartzItself.listener.jobListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class Job2 implements Job {

	public void execute(JobExecutionContext context)
			throws JobExecutionException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		JobKey jobKey = context.getJobDetail().getKey();

		System.err.println("\nJob2 - 任务key "
				+ jobKey
				+ "执行时间："
				+ sdf.format(new Date()));
	}
}
