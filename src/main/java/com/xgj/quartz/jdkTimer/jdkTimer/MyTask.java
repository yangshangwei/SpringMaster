package com.xgj.quartz.jdkTimer.jdkTimer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * 
 * 
 * @ClassName: MyTask
 * 
 * @Description: 任务执行10次后退出
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月17日 下午5:01:32
 */
public class MyTask extends TimerTask {

	int count = 0;

	@Override
	public void run() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("Task begins to execute,execute times:" + count);
		
		Date date = new Date(scheduledExecutionTime());
		
		System.out.println("本次任务执行时间点为:" + sdf.format(date));
		
		// 执行10次后退出
		if (++count > 10) {
			cancel();
			System.out.println("Task exits");
		}
		

	}

}
