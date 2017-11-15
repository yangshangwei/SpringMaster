package com.xgj.quartz.quartzItself.interruptableJob;

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
 * @ClassName: InterruptExample
 * 
 * @Description: 调度类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月15日 上午9:28:21
 */

public class InterruptExample {

	public void run() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println("------- 初始化 ----------------------");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		// 下一个15秒
		Date startTime = nextGivenSecondDate(null, 15);

		// 当前时间15秒后,每间隔5秒执行一次任务
		JobDetail job = newJob(DumbInterruptableJob.class).withIdentity(
				"interruptableJob1", "group1").build();
		SimpleTrigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.startAt(startTime)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(5)
								.repeatForever()).build();

		Date ft = sched.scheduleJob(job, trigger);
		System.out.println(job.getKey() + " 将运行于：" + sdf.format(ft) + " 并重复："
				+ trigger.getRepeatCount() + " 次，间隔 "
				+ trigger.getRepeatInterval() / 1000 + " 秒");

		// 调度开始执行
		sched.start();
		System.out.println("------- 开始调度 (调用.start()方法) ----------------");

		System.out.println("------- 每7秒钟启动一次中断任务（10次中断） ----------");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(7000L);

				// 手动中断调度器中的job
				sched.interrupt(job.getKey());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("------- 关闭调度 ---------------------");

		sched.shutdown(true);

		System.out.println("------- 关闭调度器完成 -----------------");
		SchedulerMetaData metaData = sched.getMetaData();

		System.out.println("~~~~~~~~~~  执行了 "
				+ metaData.getNumberOfJobsExecuted() + " 个 jobs.");

	}

	public static void main(String[] args) throws Exception {
		InterruptExample example = new InterruptExample();
		example.run();
	}
}
