package com.xgj.quartz.quartzItself.jobDataMapOfficalDemo;

import static org.quartz.DateBuilder.nextGivenSecondDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobStateExample {

	public void run() throws Exception {
		Logger log = LoggerFactory.getLogger(JobStateExample.class);
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		// 在当前时间10秒后运行
		Date startTime = nextGivenSecondDate(null, 10);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		// 通过过JobDetail封装ColorJob，同时指定Job在Scheduler中所属组及名称，这里，组名为group1，而名称为job1。
		JobDetail job1 = newJob(ColorJob.class).withIdentity("job1", "group1")
				.build();

		// 创建一个SimpleTrigger实例，指定该Trigger在Scheduler中所属组及名称。
		// 接着设置调度的时间规则.当前时间10秒后运行，每10秒运行一次，共运行4次
		SimpleTrigger trigger1 = newTrigger()
				.withIdentity("trigger1", "group1")
				.startAt(startTime)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(10)
								.withRepeatCount(4)).build();

		// 将参数传递入任务的数据Map中
		job1.getJobDataMap().put(ColorJob.FAVORITE_COLOR, "绿色");
		job1.getJobDataMap().put(ColorJob.EXECUTION_COUNT, 1);

		// 注册并进行调度
		Date scheduleTime1 = sched.scheduleJob(job1, trigger1);

		log.error("任务key: " + job1.getKey() + ",执行运行时间: "
				+ sdf.format(scheduleTime1) + ",触发器重复执行次数: "
				+ trigger1.getRepeatCount() + ",触发器执行时间: "
				+ trigger1.getRepeatInterval() / 1000 + "秒");

		// 第二个任务
		JobDetail job2 = newJob(ColorJob.class).withIdentity("job2", "group1")
				.build();

		SimpleTrigger trigger2 = newTrigger()
				.withIdentity("trigger2", "group1")
				.startAt(startTime)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(10)
								.withRepeatCount(4)).build();

		// 传递数据
		job2.getJobDataMap().put(ColorJob.FAVORITE_COLOR, "红色");
		job2.getJobDataMap().put(ColorJob.EXECUTION_COUNT, 1);

		Date scheduleTime2 = sched.scheduleJob(job2, trigger2);

		log.error("第二个任务key: " + job2.getKey().toString() + ",执行运行时间: "
				+ sdf.format(scheduleTime2) + ",触发器重复执行次数: "
				+ trigger2.getRepeatCount() + ",触发器执行时间: "
				+ trigger2.getRepeatInterval() / 1000 + "秒");

		// 调度器启动
		sched.start();

		try {
			Thread.sleep(60L * 1000L);
		} catch (Exception e) {
		}

		// 调度器停止
		sched.shutdown(true);

		SchedulerMetaData metaData = sched.getMetaData();
		log.error("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");

	}

	public static void main(String[] args) throws Exception {

		JobStateExample example = new JobStateExample();
		example.run();
	}

}