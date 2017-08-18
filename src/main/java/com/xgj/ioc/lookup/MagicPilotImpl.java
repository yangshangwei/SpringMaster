package com.xgj.ioc.lookup;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MagicPilotImpl implements MagicPilot, ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public Plane getPlane() {
		return (Plane) applicationContext.getBean("plane");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;

	}
}
