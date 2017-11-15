package com.xgj.quartz.quartzItself.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;

/**
 * 
 * 
 * @ClassName: BadJob2
 * 
 * @Description: setUnscheduleAllTriggers
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月15日 上午1:10:24
 */

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class BadJob2 implements Job {
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		JobKey jobKey = context.getJobDetail().getKey();
		System.out.println("---" + jobKey + " ，执行时间："
				+ dateFormat.format(new Date()));

		try {
			int result = 4815 / 0;

		} catch (Exception e) {
			System.out.println("--- job2 出错!");

			// Quartz将自动取消与此作业相关联的所有触发器，以使其不再运行
			JobExecutionException e2 = new JobExecutionException(e);
			e2.setUnscheduleAllTriggers(true);

			throw e2;
		}

		System.out.println("---" + jobKey + "，完成时间："
				+ dateFormat.format(new Date()));
	}

}
