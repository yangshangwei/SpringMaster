package com.xgj.quartz.quartzItself.calendarDemo.DailyCalendar;

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
import org.quartz.impl.calendar.DailyCalendar;

import com.xgj.quartz.quartzItself.calendarDemo.SimpleJob;
/**
 * 
 * 
 * @ClassName: DailyCalendarDemo
 * 
 * @Description: 注意：dailyCalendar.setInvertTimeRange(true); //
 *               时间反转，为true表示只有这次时间段才会被执行，为false表示排除这时间段
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月15日 下午5:40:00
 */
public class DailyCalendarDemo {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println("-------  初始化 ----------");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		DailyCalendar dailyCalendar = new DailyCalendar("12:17:30", "12:18:20");
		dailyCalendar.setInvertTimeRange(true); // 时间反转，为true表示只有这次时间段才会被执行，为false表示排除这时间段

		// 标明要排除的日期 每天的17点10分
		sched.addCalendar("dailyCalendar", dailyCalendar, false, false); // 节假日加入schedule调度器

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
				.modifiedByCalendar("dailyCalendar").build();

		Date firstRunTime = sched.scheduleJob(job, trigger);

		System.out.println(job.getKey() + " 将运行于：" + sdf.format(firstRunTime)
				+ " 并重复：" + trigger.getRepeatCount() + " 次, 间隔 "
				+ trigger.getRepeatInterval() / 1000 + " 秒");

		System.out.println("------- 开始 Scheduler ----------------");
		sched.start();

		System.out.println("------- 等待 360 秒（3分钟）... --------------");
		try {
			Thread.sleep(360L * 1000L);
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
