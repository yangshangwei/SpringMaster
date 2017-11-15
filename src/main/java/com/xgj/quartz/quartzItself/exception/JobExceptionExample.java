package com.xgj.quartz.quartzItself.exception;

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

/**
 * 
 * 
 * @ClassName: JobExceptionExample
 * 
 * @Description: 演示 Quartz 如何处理 从job中抛出的 JobExecutionExceptions
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月15日 上午1:10:02
 */
public class JobExceptionExample {
	public void run() throws Exception {
		// 任务执行的时间 格式化
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		System.out.println("--------------- 初始化 -------------------");

		// 下一个15秒
		Date startTime = nextGivenSecondDate(null, 15);

		// badJob1 每10s执行一次 , 抛出异常,并立即重新执行
		JobDetail job = newJob(BadJob1.class).withIdentity("badJob1", "group1")
				.usingJobData("flag", "0").build();
		SimpleTrigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.startAt(startTime)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(10)
								.repeatForever()).build();

		Date ft = sched.scheduleJob(job, trigger);
		System.out.println(job.getKey().getName() + " 将在: "
				+ dateFormat.format(ft) + "  时运行.并且重复: "
				+ trigger.getRepeatCount() + " 次, 每次间隔 "
				+ trigger.getRepeatInterval() / 1000 + " 秒");

	        // badJob2 每5秒执行一次 , 并且 会抛出异常,然后 不再执行
		job = newJob(BadJob2.class).withIdentity("badJob2", "group1").build();
		trigger = newTrigger()
				.withIdentity("trigger2", "group1")
				.startAt(startTime)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(5)
								.repeatForever()).build();

		ft = sched.scheduleJob(job, trigger);

		System.out.println(job.getKey().getName() + " 将在: "
				+ dateFormat.format(ft) + "  时运行.并且重复: "
				+ trigger.getRepeatCount() + " 次, 每次间隔 "
				+ trigger.getRepeatInterval() / 1000 + " 秒");

		sched.start();
		System.out.println("------- 开始调度 (调用.start()方法) ----------------");

		try {
			// 睡眠 30s
			Thread.sleep(60L * 1000L);
		} catch (Exception e) {
		}

		sched.shutdown(false);

		// 显示一下 已经执行的任务信息
		SchedulerMetaData metaData = sched.getMetaData();
		System.out.println("~~~~~~~~~~  执行了 "
				+ metaData.getNumberOfJobsExecuted() + " 个 jobs.");
	}

	public static void main(String[] args) throws Exception {

		JobExceptionExample example = new JobExceptionExample();
		example.run();
	}
}
