package com.xgj.quartz.jdkTimer.jdkTimer;

import java.util.Timer;

public class TimerRunner {

	public static void main(String[] args) {
		Timer timer = new Timer();
		MyTask myTask = new MyTask();
		// 延迟1秒，每5S执行一次任务
		timer.schedule(myTask, 1000L, 5000L);

	}
}
