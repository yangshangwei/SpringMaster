package com.xgj.quartz.quartzItself.jobDataMap;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class MyJob2Runner {

	public static void main(String[] args) {

		try {
			// Grab the Scheduler instance from the Factory
			SchedulerFactory factory = new StdSchedulerFactory();
			Scheduler scheduler = factory.getScheduler();

			// start
			scheduler.start();

			// define the job and tie it to our MyJob class
			JobDetail job = newJob(MyJob21.class)
					.withIdentity("myJob", "group1")
					.usingJobData("jobSays", "Hello World!")
					.usingJobData("myFloatValue", 3.141f)
					.build();

			// Trigger the job to run now, and then every 40 seconds
			Trigger trigger = newTrigger()
					.withIdentity("myTrigger", "group1")
					.startNow()
					.withSchedule(
							simpleSchedule().withIntervalInSeconds(40)
									.repeatForever()).build();

			// Tell quartz to schedule the job using our trigger
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}
}
