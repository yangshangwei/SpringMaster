package com.xgj.aop.spring.advisor.aspectJ.function.execution.classpoint;

public class CleanerOne implements Cleaner {

	@Override
	public void cleanTable() {
		System.out.println("CleanerOne cleanTable");
	}

	@Override
	public void cleanWindow() {
		System.out.println("CleanerOne cleanWindow");
	}

	public void cleanFloor() {
		System.out.println("CleanerOne cleanFloor");
	}

}
