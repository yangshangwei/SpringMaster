package com.xgj.quartz.quartzItself.listener.schedulerListener;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

public class MySchedulerListener implements SchedulerListener {

	@Override
	public void jobScheduled(Trigger trigger) {
		System.out.println("MySchedulerListener jobScheduled trigger");

	}

	@Override
	public void jobUnscheduled(TriggerKey triggerKey) {
		System.out.println("MySchedulerListener jobScheduled triggerKey");

	}

	@Override
	public void triggerFinalized(Trigger trigger) {
		System.out.println("MySchedulerListener triggerFinalized");

	}

	@Override
	public void triggerPaused(TriggerKey triggerKey) {
		System.out.println("MySchedulerListener triggerPaused");

	}

	@Override
	public void triggersPaused(String triggerGroup) {
		System.out.println("MySchedulerListener triggersPaused");

	}

	@Override
	public void triggerResumed(TriggerKey triggerKey) {
		System.out.println("MySchedulerListener triggerResumed triggerKey");

	}

	@Override
	public void triggersResumed(String triggerGroup) {
		System.out.println("MySchedulerListener triggerResumed triggerGroup");

	}

	@Override
	public void jobAdded(JobDetail jobDetail) {
		System.out.println("MySchedulerListener jobAdded");
	}

	@Override
	public void jobDeleted(JobKey jobKey) {
		System.out.println("MySchedulerListener jobDeleted");

	}

	@Override
	public void jobPaused(JobKey jobKey) {
		System.out.println("MySchedulerListener jobPaused jobKey");

	}

	@Override
	public void jobsPaused(String jobGroup) {
		System.out.println("MySchedulerListener jobsPaused jobGroup");

	}

	@Override
	public void jobResumed(JobKey jobKey) {
		System.out.println("MySchedulerListener jobResumed  jobKey");

	}

	@Override
	public void jobsResumed(String jobGroup) {
		System.out.println("MySchedulerListener jobsResumed  jobGroup");

	}

	@Override
	public void schedulerError(String msg, SchedulerException cause) {
		System.out.println("MySchedulerListener schedulerError");

	}

	@Override
	public void schedulerInStandbyMode() {
		System.out.println("MySchedulerListener schedulerInStandbyMode");

	}

	@Override
	public void schedulerStarted() {
		System.out.println("MySchedulerListener schedulerStarted");

	}

	@Override
	public void schedulerStarting() {
		System.out.println("MySchedulerListener schedulerStarting");

	}

	@Override
	public void schedulerShutdown() {
		System.out.println("MySchedulerListener schedulerShutdown");

	}

	@Override
	public void schedulerShuttingdown() {
		System.out.println("MySchedulerListener schedulerShuttingdown");

	}

	@Override
	public void schedulingDataCleared() {
		System.out.println("MySchedulerListener schedulingDataCleared");

	}

}
