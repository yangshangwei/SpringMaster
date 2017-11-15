package com.xgj.quartz.quartzItself.jobDataMapOfficalDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class ColorJob implements Job {

	public static final String FAVORITE_COLOR = "favorite color";
	public static final String EXECUTION_COUNT = "count";

	// 由于Quartz会在每次执行时重新实例化一个类，因此成员非静态成员变量不能用于维护状态！
	private int _counter = 1;

	public void execute(JobExecutionContext context)
			throws JobExecutionException {

		JobKey jobKey = context.getJobDetail().getKey();

		JobDataMap data = context.getJobDetail().getJobDataMap();
		String favoriteColor = data.getString(FAVORITE_COLOR);
		int count = data.getInt(EXECUTION_COUNT);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		System.out.println("任务Key: " + jobKey + " ,执行时间:  "
				+ sdf.format(new Date()) + "\n" + "  传递参数(favorite color): "
				+ favoriteColor + "\n" + "  传递参数(count):  " + count + "\n"
				+ "  ColorJob非静态变量值: " + _counter + "\n");

		count++;
		data.put(EXECUTION_COUNT, count);
		data.put(FAVORITE_COLOR, "黄色");

		_counter++;
	}

}
