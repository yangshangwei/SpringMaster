package com.xgj.quartz.quartzItself.useQuartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * 
 * @ClassName: QuartzRun
 * 
 * @Description: 在使用 scheduler （调度器）之前，首先要创建实例。创建实例需要用到 SchedulerFactory 类。
 * 
 *               有的Quartz使用者喜欢将这个工厂对象放入 JNDI中存储，另外一些用户喜欢简单地实例化工厂类（下面的例子就使用这种方式）。
 * 
 *               一旦 Scheduler 实例被创建，你就可以进行启动，待命，关闭操作。
 * 
 *               记住，一旦 Scheduler 关闭后，就不能重新启动，而是需要创建另一个 Scheduler实例。如果 Scheduler
 *               没有启动，或者触发器处于暂停状态，那么触发器不会被触发（也不会执行任何任务）。
 * 
 *               下面是一段简单的代码，其中创建了 Scheduler 实例，并且安排了一些执行的任务：
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年10月7日 上午12:37:17
 */
public class QuartzRun {


	public static void main(String[] args) {

		try {
			// Grab the Scheduler instance from the Factory
			SchedulerFactory factory = new StdSchedulerFactory();
			Scheduler scheduler = factory.getScheduler();

			// start
			scheduler.start();

			// define the job and tie it to our MyJob class
			JobDetail job = newJob(MyJob.class).withIdentity("myJob",
					"group1").build();
			
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
