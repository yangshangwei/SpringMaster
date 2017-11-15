package com.xgj.quartz.quartzItself.interruptableJob;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.UnableToInterruptJobException;

/**
 * 
 * 
 * @ClassName: DumbInterruptableJob
 * 
 * @Description: 个可执行的中断可执行程序，用于单元测试。
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月15日 上午9:26:36
 */

public class DumbInterruptableJob implements InterruptableJob {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private boolean _interrupted = false; // job 是否中断
	private JobKey _jobKey = null; // job name

	private static int counts = 0; // 中断执行次数

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {

		_jobKey = context.getJobDetail().getKey();

		System.out.println("【开始执行】任务Key：" + _jobKey + "，执行时间： "
				+ sdf.format(new Date()));

		try {

			for (int i = 0; i < 4; i++) {
				try {
					Thread.sleep(1000L);
				} catch (Exception e) {
					e.printStackTrace();
				}

				// 查看是否中断
				if (_interrupted) {
					counts++;
					System.out.println("被外界因素停止了这个任务key：" + _jobKey
							+ ",中断累计次数: " + counts + "\n");
					return; // 也可以选择抛出一个JobExecutionException，根据业务需要指定行为
				}
			}

		} finally {
			System.out.println("【完成任务】key：" + _jobKey + " 完成时间："
					+ sdf.format(new Date()));
		}

	}

	@Override
	public void interrupt() throws UnableToInterruptJobException {
		System.out.println("\n—————— 【中断】外界正在调用调度器停止这个任务key：" + _jobKey
				+ " ————————");
		_interrupted = true;

	}

}
