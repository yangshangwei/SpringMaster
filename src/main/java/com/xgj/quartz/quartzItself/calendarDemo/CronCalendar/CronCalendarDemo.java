package com.xgj.quartz.quartzItself.calendarDemo.CronCalendar;

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
import org.quartz.impl.calendar.CronCalendar;

import com.xgj.quartz.quartzItself.calendarDemo.SimpleJob;

public class CronCalendarDemo {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println("-------  初始化 ----------");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		// 允许执行的时间, 星期参数："7" = "SAT",2 = MON
		// 【秒】 【分钟】 【小时】 【月中天】 【月】 【周中天(1-7)】 [【年(可省略)】]
		String excludeExpression;

		// 这里设置禁用时间段为，每0-20之间，40-59之间不执行
		excludeExpression = "0-20,40-59 * * * * ?";
		CronCalendar cronCalendar = new CronCalendar(excludeExpression);

		// 标明要排除的日期 每天的17点10分
		sched.addCalendar("cronCalendar", cronCalendar, false, false); // 节假日加入schedule调度器

		Date runDate = new Date();
		System.out.println("任务开始时间：" + sdf.format(runDate));

		// 任务每10秒执行一次
		JobDetail job = newJob(SimpleJob.class).withIdentity("job1", "group1")
				.build();
		SimpleTrigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.startAt(runDate)
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(10)
								.repeatForever())
				.modifiedByCalendar("cronCalendar").build();

		// 触发器加入调度器
		Date firstRunTime = sched.scheduleJob(job, trigger);

		System.out.println(job.getKey() + " 将运行于：" + sdf.format(firstRunTime)
				+ " 并重复：" + trigger.getRepeatCount() + " 次, 间隔 "
				+ trigger.getRepeatInterval() / 1000 + " 秒");

		System.out.println("------- 开始 Scheduler ----------------");
		sched.start();

		try {
			System.out.println("------- 等待 120 秒（2分钟）... --------------");
			Thread.sleep(120L * 1000L);
			// do something
		} catch (Exception e) {
		}

		sched.shutdown(true);
		System.out.println("------- 关闭调度器 -----------------");

		SchedulerMetaData metaData = sched.getMetaData();
		System.out.println("~~~~~~~~~~  执行了 "
				+ metaData.getNumberOfJobsExecuted() + " 个 jobs.");

	}
}
