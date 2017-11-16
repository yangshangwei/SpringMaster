package com.xgj.quartz.quartzItself.listener.triggerListener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

public class MyTriggerListener implements TriggerListener {
	@Override
	public String getName() {
		return "MyTriggerListener";
	}

	/**
	 * (1) Trigger被激发 它关联的job即将被运行
	 *
	 * @param trigger
	 * @param context
	 */
	@Override
	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		System.out.println("MyTrigger监听器：" + trigger.getJobKey()
				+ "，进入方法 triggerFired()");
	}

	/**
	 * (2) Trigger被激发 它关联的job即将被运行,先执行(1)，在执行(2) 如果返回TRUE 那么任务job会被终止
	 *
	 * @param trigger
	 * @param context
	 * @return
	 */
	@Override
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
		System.out.println("MyTrigger监听器：" + trigger.getJobKey()
				+ "，vetoJobExecution()");
		return false;
	}

	/**
	 * (3) 当Trigger错过被激发时执行,比如当前时间有很多触发器都需要执行，但是线程池中的有效线程都在工作，那么有的触发器就有可能超时，
	 * 错过这一轮的触发。
	 *
	 * @param trigger
	 */
	@Override
	public void triggerMisfired(Trigger trigger) {
		System.out.println("MyTrigger监听器：" + trigger.getJobKey()
				+ "，triggerMisfired()");
	}

	/**
	 * (4) 任务完成时触发
	 *
	 * @param trigger
	 * @param jobExecutionContext
	 * @param completedExecutionInstruction
	 */
	@Override
	public void triggerComplete(Trigger trigger,
			JobExecutionContext jobExecutionContext,
			Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
		System.out.println("MyTrigger监听器：" + trigger.getJobKey()
				+ "，triggerComplete()");
	}
}
