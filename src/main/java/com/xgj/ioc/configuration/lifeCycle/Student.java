package com.xgj.ioc.configuration.lifeCycle;

import org.springframework.stereotype.Component;

@Component
public class Student {

	public Student() {
		super();
		System.out.println("Student is initing....");
	}

}
