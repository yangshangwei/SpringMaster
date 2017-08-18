package com.xgj.ioc.refOtherBeanProByXml;


public class ApplicationManager {

	private int sessionTimeout;

	private int maxTabPageNum;

	public int getSessionTimeout() {
		System.out.println("sessionTimeout:" + sessionTimeout);
		return sessionTimeout;
	}

	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	public int getMaxTabPageNum() {
		System.out.println("maxTabPageNum:" + maxTabPageNum);
		return maxTabPageNum;
	}

	public void setMaxTabPageNum(int maxTabPageNum) {
		this.maxTabPageNum = maxTabPageNum;
	}

}
