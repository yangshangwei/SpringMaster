package com.xgj.quartz.quartzItself.misfire;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

/**
 * 
 * 
 * @ClassName: StatefulDumbJob
 * 
 * @Description: 通过设置错失触发后的调度策略，来处理错过的任务.
 * 
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月14日 下午9:36:52
 */

// 在Job被执行结束后，将会更新JobDataMap，这样下次Job执行后就会使用新的值而不是初始值
@PersistJobDataAfterExecution
// 同一时间将只有一个Job实例被执行, 为了避免并发问题导致数据紊乱,建议这两个注解一起使用
@DisallowConcurrentExecution
public class StatefulDumbJob implements Job {

	// 静态常量，作为任务在调用间，保持数据的键(key)

	public static final String NUM_EXECUTIONS = "NumExecutions"; // 保存的计数每次递增1
	public static final String EXECUTION_DELAY = "ExecutionDelay"; // 任务在执行时，中间睡眠的时间。本例中睡眠时间过长导致了错失触发

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String jobRunTime = dateFormat.format(new Date());

		System.err.println("---" + context.getJobDetail().getKey().getName()
				+ " 在  : [" + jobRunTime + "] 执行了!!");

		// 任务执行计数 累加
		JobDataMap map = context.getJobDetail().getJobDataMap();
		int executeCount = 0;
		if (map.containsKey(NUM_EXECUTIONS)) {
			executeCount = map.getInt(NUM_EXECUTIONS);
		}
		executeCount++;
		map.put(NUM_EXECUTIONS, executeCount);

		// 睡眠时间: 由调度类重新设置值 ,本例为 睡眠10s
		long delay = 5000l;
		if (map.containsKey(EXECUTION_DELAY)) {
			delay = map.getLong(EXECUTION_DELAY);
		}

		try {
			Thread.sleep(delay);
		} catch (Exception ignore) {
		}

		// 睡眠醒来后，打印任务执行结束的信息
		System.err.println("  -" + context.getJobDetail().getKey().getName()
				+ " 完成次数  : " + executeCount);

	}

}
