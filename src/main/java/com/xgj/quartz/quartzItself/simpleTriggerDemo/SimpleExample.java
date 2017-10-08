package com.xgj.quartz.quartzItself.simpleTriggerDemo;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * 
 * @ClassName: SimpleExample
 * 
 * @Description: This Example will demonstrate how to start and shutdown the
 *               Quartz scheduler and how to schedule a job to run in Quartz
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年10月7日 下午7:30:41
 */
public class SimpleExample {



	public void run() throws Exception {
		Logger log = Logger.getLogger(SimpleExample.class);

		log.info("------- Initializing ----------------------");

		// First we must get a reference to a scheduler
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = sf.getScheduler();

		log.info("------- Initialization Complete -----------");
		
		// Now
		log.info("------- now -----------" + new Date());
		// computer a time that is on the next round minute
		Date runTime = evenMinuteDate(new Date());

		log.info("------- Scheduling Job  -------------------");

		// define the job and tie it to our HelloJob class
		JobDetail job = newJob(HelloJob.class)
				.withIdentity("job1", "group1")
				.build();
		
		// Trigger the job to run on the next round minute
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
				.startAt(runTime)
				.build();
		
		// Tell quartz to schedule the job using our trigger
		scheduler.scheduleJob(job, trigger);
		log.info(job.getKey() + " will run at: " + runTime);

		// Start up the scheduler (nothing can actually run until the
		// scheduler has been started)
		scheduler.start();
		log.info("------- Started Scheduler -----------------");

		// wait long enough so that the scheduler as an opportunity to
		// run the job!
		log.info("------- Waiting 60 seconds... -------------");
		try {
			// wait 65 seconds to show job
			Thread.sleep(60L * 1000L);
			// executing...
		} catch (Exception e) {
			//
		}

		// shut down the scheduler
		log.info("------- Shutting Down ---------------------");
		scheduler.shutdown(true);
		log.info("------- Shutdown Complete -----------------");
	}


	public static void main(String[] args) throws Exception {
		SimpleExample simpleExample = new SimpleExample();
		simpleExample.run();
	}

}
