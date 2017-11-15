package com.xgj.quartz.quartzItself.misfire;

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

public class MisfireExample {

	public void run() throws Exception {

		// 任务执行的时间 格式化
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		System.out.println("--------------- 初始化 -------------------");

		// 下一个第15秒
		Date startTime = nextGivenSecondDate(null, 15);

		// statefulJob1 每3s运行一次,但它会延迟10s
		JobDetail job = newJob(StatefulDumbJob.class)
				.withIdentity("statefulJob1", "group1")
				.usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L) // 设置参数:睡眠时间10s
				.build();
		SimpleTrigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.startAt(startTime)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(3)
								.repeatForever()).build();


		Date ft = sched.scheduleJob(job, trigger);
		System.out.println(job.getKey().getName() + " 将在: "
				+ dateFormat.format(ft) + "  时运行.并且重复: "
				+ trigger.getRepeatCount() + " 次, 每次间隔 "
				+ trigger.getRepeatInterval() / 1000 + " 秒");

		// statefulJob2 将每3s运行一次 , 但它将延迟10s, 然后不断的迭代,
		// 与statefulJob1不同的是设置了错失触发后的调整策略
		job = newJob(StatefulDumbJob.class)
				.withIdentity("statefulJob2", "group1")
				.usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L)// 设置参数:睡眠时间
																		// 10s
				.build();
		trigger = newTrigger()
				.withIdentity("trigger2", "group1")
				.startAt(startTime)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(3)
								.repeatForever()
								// 设置错失触发后的调度策略
								.withMisfireHandlingInstructionNowWithRemainingCount())
				.build();

		ft = sched.scheduleJob(job, trigger);
		System.out.println(job.getKey().getName() + " 将在: "
				+ dateFormat.format(ft) + "  时运行.并且重复: "
				+ trigger.getRepeatCount() + " 次, 每次间隔 "
				+ trigger.getRepeatInterval() / 1000 + " 秒");

		System.out.println("------- 开始调度 (调用.start()方法) ----------------");
		sched.start();

		// 给任务留时间运行 600S
		Thread.sleep(600L * 1000L);

		sched.shutdown(true);
		System.out.println("------- 调度已关闭 ---------------------");

		// 显示一下 已经执行的任务信息
		SchedulerMetaData metaData = sched.getMetaData();
		System.out.println("~~~~~~~~~~  执行了 "
				+ metaData.getNumberOfJobsExecuted() + " 个 jobs.");
	}



	public static void main(String[] args) throws Exception {
		MisfireExample misfireExample = new MisfireExample();
		misfireExample.run();
	}
}
