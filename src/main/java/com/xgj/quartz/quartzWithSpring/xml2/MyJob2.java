package com.xgj.quartz.quartzWithSpring.xml2;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 * 
 * @ClassName: MyJob2
 * 
 * @Description: 配置文件中使用JobDetailBean,这是业务Job需要继承QuartzJobBean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年11月12日 上午7:54:28
 */
public class MyJob2 extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException {
		System.out.println("Spring 集成 Quartz 的第二种方式");
	}

}
