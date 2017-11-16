package com.xgj.quartz.quartzItself.dateBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.quartz.DateBuilder;

/**
 * 
 * 
 * @ClassName: DateBuilderDemo
 * 
 * @Description: API: http://www.quartz-scheduler.org/api/2.2.1/index.html
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月16日 上午12:29:57
 */
public class DateBuilderDemo {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// todayAt
		Date runTime = DateBuilder.todayAt(17, 30, 45);
		System.out.println("当前时间：" + sdf.format(new Date()));
		System.out.println("runTime：" + sdf.format(runTime));

		// evenMinuteDate
		runTime = DateBuilder.evenMinuteDate(new Date());
		System.out.println("当前时间：" + sdf.format(new Date()));
		System.out.println("runTime：" + sdf.format(runTime));

		// evenMinuteDateBefore
		runTime = DateBuilder.evenMinuteDateBefore(new Date());
		System.out.println("当前时间：" + sdf.format(new Date()));
		System.out.println("runTime：" + sdf.format(runTime));

		// dateof
		Date dateOf_1 = DateBuilder.dateOf(13, 10, 10);
		Date dateOf_2 = DateBuilder.dateOf(13, 10, 10, 1, 1);
		Date dateOf_3 = DateBuilder.dateOf(13, 10, 10, 1, 1, 2016);

		System.out.println("当前时间：" + sdf.format(new Date()));
		System.out.println("dateOf_1：" + sdf.format(dateOf_1));
		System.out.println("dateOf_2：" + sdf.format(dateOf_2));
		System.out.println("dateOf_3：" + sdf.format(dateOf_3));

		// nextGivenMinuteDate
		runTime = DateBuilder.nextGivenMinuteDate(new Date(), 1);
		System.out.println("当前时间：" + sdf.format(new Date()));
		System.out.println("runTime：" + sdf.format(runTime));

		// translateTime
		// 转换时区 “美国/洛杉矶”
		runTime = DateBuilder.translateTime(new Date(), TimeZone.getDefault(),
				TimeZone.getTimeZone("America/Los_Angeles"));

		System.out.println("当前时间：" + sdf.format(new Date()));
		System.out.println("runTime：" + sdf.format(runTime));

		// futureDate
		runTime = DateBuilder.futureDate(10, DateBuilder.IntervalUnit.MINUTE);
		System.out.println("当前时间：" + sdf.format(new Date()));
		System.out.println("runTime：" + sdf.format(runTime));

	}

}
