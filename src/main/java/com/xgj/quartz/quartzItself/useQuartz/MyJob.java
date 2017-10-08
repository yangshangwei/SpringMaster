package com.xgj.quartz.quartzItself.useQuartz;

import java.text.SimpleDateFormat;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		System.out.println(" triggered time is "
				+ dateFormat.format(new java.util.Date()));

	}

}
