package com.xgj.quartz.quartzItself.saveInfoInDB;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class QuartzPersistenceTest {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {

			System.out.println("------- 初始化 ----------------------");

			// 通过调度器工厂获取调度器，初始化工程时须指定其使用我们自己的配置文件
			SchedulerFactory sf = new StdSchedulerFactory(
					"quartz/quartz.properties");
			Scheduler sched = sf.getScheduler();

			// clear一下，因为使用数据库储存方式时，shutdown的时候没有清除，第二次运行会报Job is already
			// exist
			sched.clear();

			System.out.println("------- 初始化完成 -----------");

			// 下一分钟开始执行
			Date runTime = DateBuilder.evenMinuteDate(new Date());

			System.out.println("------- Scheduling Job  -------------------");

			// 任务详情
			JobDetail job = JobBuilder.newJob(MyPersistenceJob.class)
					.withIdentity("artisanJob", "artisanGroup").build();

			// 触发器 重复20+1次 间隔2秒
			SimpleTriggerImpl trigger = (SimpleTriggerImpl) TriggerBuilder
					.newTrigger()
					.withIdentity("artisanTrigger", "artisanGroup")
					.startAt(runTime).build();
			trigger.setRepeatCount(20);
			trigger.setRepeatInterval(2000);

			System.out.println("------- 当前时间：" + sdf.format(new Date())
					+ " -----------------");

			// 调度器、触发器、任务，三者关联
			sched.scheduleJob(job, trigger);

			System.out.println(job.getKey() + " 开始job运行时间："
					+ sdf.format(runTime));

			// 调度启动
			sched.start();
			System.out.println("------- 开始调度器 Scheduler -----------------");
			
			/** 第二次运行 将该段屏蔽
			System.out.println("------- 等待10秒-------------");
			try {
				Thread.sleep(1 * 10000L);
			} catch (Exception e) {
			}

			System.out.println("------- 关闭调度器 模拟异常退出---------------------");
			sched.shutdown(true);

			System.out.println("------- 异常退出 -----------------");
			**/
			SchedulerMetaData metaData = sched.getMetaData();
			System.out.println("目前执行了 "
					+ metaData.getNumberOfJobsExecuted() + " 个 jobs.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
