package com.xgj.quartz.quartzItself.jobDataMap;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class MyJob21 implements Job {

	private String jobSays;
	private float myFloatValue;

	public MyJob21() {
	}

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {

		JobKey key = context.getJobDetail().getKey();

		// Note the difference from the previous
		JobDataMap dataMap = context.getMergedJobDataMap();

		System.err.println("Instance " + key + " of MyJob2 says: " + jobSays
				+ ", and val is: " + myFloatValue);
	}

	public void setJobSays(String jobSays) {
		this.jobSays = jobSays;
	}

	public void setMyFloatValue(float myFloatValue) {
		this.myFloatValue = myFloatValue;
	}

}
