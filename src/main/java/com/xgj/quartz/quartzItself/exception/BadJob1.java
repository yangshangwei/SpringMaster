package com.xgj.quartz.quartzItself.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;

/**
 * 
 * 
 * @ClassName: BadJob1
 * 
 * @Description: setRefireImmediately
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月15日 上午1:10:17
 */

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class BadJob1 implements Job {

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		JobKey jobKey = context.getJobDetail().getKey();
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();

		int flag = dataMap.getInt("flag");
		System.out.println("---" + jobKey + "，执行时间："
				+ dateFormat.format(new Date()) + ", flag： " + flag);

		// 由于零错误除以此作业将生成的异常的例外（仅在第一次运行）
		try {
			int result = 4815 / flag;

		} catch (Exception e) {
			System.out.println("--- Job1 出错!");

			// 修复分母，所以下次这个作业运行它不会再失败
			JobExecutionException e2 = new JobExecutionException(e);
			dataMap.put("flag", "1");

			// 这个工作会立即重新启动
			e2.setRefireImmediately(true);

			throw e2;
		}

		System.out.println("---" + jobKey + "，完成时间："
				+ dateFormat.format(new Date()));
    }


}
