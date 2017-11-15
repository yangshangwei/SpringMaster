package com.xgj.quartz.quartzItself.executeTimesCount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;

/**
 * 
 * 
 * @ClassName: CountExecuteTimes
 * 
 * @Description: 使用quartz做为后台任务调度框架，cron表达式设置时间，需要根据cron表达式计算出最近n次的执行具体时间--
 *               这个通常在开放给用户修改任务执行时间给出提示时非常有用.
 * 
 *               方法：使用quartz的jar包中提供的TriggerUtils类来计算
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月15日 上午11:24:03
 */
public class CountExecuteTimes {

	public static void main(String[] args) {

		try {

			CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();

			// 每天早上10：15触发
			cronTriggerImpl.setCronExpression("0 15 10 * * ?");

			Calendar calendar = Calendar.getInstance();
			Date now = calendar.getTime();
			calendar.add(Calendar.MONTH, 1);// 把统计的区间段设置为从现在到1月后的今天（主要是为了方法通用考虑)

			// 这里的时间是根据corn表达式算出来的值
			List<Date> dates = TriggerUtils.computeFireTimesBetween(
					cronTriggerImpl, null, now,
					calendar.getTime());
			System.out.println(dates.size());

			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			for (Date date : dates) {
				System.out.println(dateFormat.format(date));
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
