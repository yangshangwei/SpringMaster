package com.xgj.aop.spring.advisor.aspectJ.function.execution.classpoint;

public class CleanerTwo implements Cleaner {

	@Override
	public void cleanTable() {
		System.out.println("CleanerTwo cleanTable");
	}

	@Override
	public void cleanWindow() {
		System.out.println("CleanerTwo cleanWindow");
	}

	public void cleanDoor() {
		System.out.println("CleanerTwo cleanDoor");
	}

}
