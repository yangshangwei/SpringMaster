package com.xgj.quartz.quartzItself.jobDataMap;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class MyJob2 implements Job {

	public MyJob2() {
	}

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {

		JobKey key = context.getJobDetail().getKey();

		JobDataMap dataMap = context.getJobDetail().getJobDataMap();

		String jobSays = dataMap.getString("jobSays");
		float myFloatValue = dataMap.getFloat("myFloatValue");

		System.err.println("Instance " + key + " of MyJob2 says: " + jobSays
				+ ", and val is: " + myFloatValue);
	}

}
