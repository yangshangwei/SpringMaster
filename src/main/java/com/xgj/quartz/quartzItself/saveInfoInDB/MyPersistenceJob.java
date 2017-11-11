package com.xgj.quartz.quartzItself.saveInfoInDB;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class MyPersistenceJob implements Job {

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {

		JobKey jobKey = context.getJobDetail().getKey();

		System.out.println("\n任务key "
				+ jobKey
				+ "执行时间："
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date()));
	}

}
