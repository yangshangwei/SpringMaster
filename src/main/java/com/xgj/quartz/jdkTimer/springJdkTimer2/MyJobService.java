package com.xgj.quartz.jdkTimer.springJdkTimer2;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MyJobService {

	public void doJob() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("本次任务执行时间点为:" + sdf.format(new Date()));

	}

}
