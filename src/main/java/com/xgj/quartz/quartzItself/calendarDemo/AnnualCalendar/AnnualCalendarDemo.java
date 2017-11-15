package com.xgj.quartz.quartzItself.calendarDemo.AnnualCalendar;

import static org.quartz.DateBuilder.dateOf;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import com.xgj.quartz.quartzItself.calendarDemo.SimpleJob;
/**
 * 
 * 
 * @ClassName: AnnualCalendarDemo
 * 
 * @Description: 此示例将演示如何使用日历来排除不应该进行调度的时间段。
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月15日 下午5:14:57
 */
public class AnnualCalendarDemo {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println("-------  初始化 ----------");

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		// 声明一个节假日 holidayCalendar，标明要排除的日期
		// 法定节日是以每年为周期的，所以使用AnnualCalendar而不是HolidayCalendar
		AnnualCalendar holidays = new AnnualCalendar();

		Calendar fourthOfJuly = new GregorianCalendar(2017, 6, 4); // fourth of
																	// July
																	// (July 4)
																	// 七月四日
		holidays.setDayExcluded(fourthOfJuly, true);
		System.out.println("第一个节假日：" + sdf.format(fourthOfJuly.getTime()));

		Calendar halloween = new GregorianCalendar(2017, 9, 31); // halloween
																	// (Oct 31)
																	// 万圣节（10月31日）
		holidays.setDayExcluded(halloween, true);
		System.out.println("第二节假日：" + sdf.format(halloween.getTime()));

		Calendar christmas = new GregorianCalendar(2017, 11, 25); // christmas
																	// (Dec 25)
																	// christmas
																	// (Dec 25)
		holidays.setDayExcluded(christmas, true);
		System.out.println("第三个节假日：" + sdf.format(christmas.getTime()));

		sched.addCalendar("holidays", holidays, false, false); // 节假日加入schedule调度器

		// 开始在万圣节前夜上午10点，开始任务
		Date runDate = dateOf(0, 0, 10, 31, 10);
		System.out.println("任务开始时间：" + sdf.format(runDate));

		JobDetail job = newJob(SimpleJob.class).withIdentity("job1", "group1")
				.build();

		SimpleTrigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.startAt(runDate)
				.withSchedule(
						simpleSchedule().withIntervalInHours(1).repeatForever())
				.modifiedByCalendar("holidays").build();

		Date firstRunTime = sched.scheduleJob(job, trigger);

		// 注意：万圣节（10月31日）是假期，所以直到第二天才会运行！ （11月1日）
		System.out.println(job.getKey() + " 将运行于：" + firstRunTime + " 并重复："
				+ trigger.getRepeatCount() + " 次, 间隔 "
				+ trigger.getRepeatInterval() / 1000 + " 秒");

		System.out.println("------- 开始 Scheduler ----------------");
		sched.start();

		System.out.println("------- 等待 30 秒... --------------");
		try {
			Thread.sleep(30L * 1000L);
		} catch (Exception e) {
		}

		sched.shutdown(true);
		System.out.println("------- 关闭调度器 -----------------");

		SchedulerMetaData metaData = sched.getMetaData();
		System.out.println("执行了： " + metaData.getNumberOfJobsExecuted()
				+ " 个jobs.");
	}

}
