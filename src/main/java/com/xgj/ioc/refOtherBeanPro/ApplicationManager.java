package com.xgj.ioc.refOtherBeanPro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationManager {

	private int sessionTimeout;

	private int maxTabPageNum;

	public int getSessionTimeout() {
		System.out.println("sessionTimeout:" + sessionTimeout);
		return sessionTimeout;
	}

	@Value("#{sysConfig.sessionTimeout}")
	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	public int getMaxTabPageNum() {
		System.out.println("maxTabPageNum:" + maxTabPageNum);
		return maxTabPageNum;
	}

	@Value("#{sysConfig.maxTabPageNum}")
	public void setMaxTabPageNum(int maxTabPageNum) {
		this.maxTabPageNum = maxTabPageNum;
	}

}
