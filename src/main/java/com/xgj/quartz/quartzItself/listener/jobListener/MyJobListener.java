package com.xgj.quartz.quartzItself.listener.jobListener;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;


/**
 * 
 * 
 * @ClassName: MyJobListener
 * 
 * @Description: 自定义Job监听器
 * 
 *               getName() ：返回一个字符串用以说明 JobListener 的名称。对于注册为全局的监听器，getName()
 *               主要用于记录日志，对于由特定 Job 引用的 JobListener，注册在 JobDetail
 *               上的监听器名称必须匹配从监听器上 getName() 方法的返回值.
 * 
 *               jobToBeExecuted() ：Scheduler 在 JobDetail 将要被执行时调用这个方法。
 * 
 *               jobExecutionVetoed() ：Scheduler 在 JobDetail 即将被执行，但又被
 *               TriggerListener 否决了时调用这个方法。
 * 
 *               jobWasExecuted() ：Scheduler 在 JobDetail 被执行之后调用这个方法。
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月16日 下午3:57:35
 */
public class MyJobListener implements JobListener {

	@Override
	public String getName() {
		return "MyJobListerner";
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		System.out.println("Job监听器：MyJobListener.jobToBeExecuted()");
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		System.out.println("Job监听器：MyJobListener.jobExecutionVetoed()");
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context,
			JobExecutionException jobException) {

		System.out.println("Job监听器：MyJobListener.jobWasExecuted()");
		
		 // 设置另外一个job执行
		JobDetail job2 = JobBuilder.newJob(Job2.class).withIdentity("job2")
				.build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("job2Trigger").startNow().build();

        try {
			context.getScheduler().scheduleJob(job2, trigger);
        } catch (SchedulerException e) {
            System.err.println("无法安排job2!");
            e.printStackTrace();
        }
		
		
	}

}
