package com.xgj.ioc.configuration.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Scope("prototype")
@Component
public class Teacher {

	private Student student;

	/**
	 * 
	 * 
	 * @Title:Teacher
	 * 
	 * @Description:¹¹Ôìº¯Êý
	 */
	public Teacher() {
		super();
		System.out.println("Teacher is initing....");
	}

	@Autowired
	public void setStudent(Student student) {
		this.student = student;
	}

	@PostConstruct
	public void init1() {
		System.out.println("init 1");
	}

	@PostConstruct
	public void init2() {
		System.out.println("init 2");
	}

	@PreDestroy
	public void destory1() {
		System.out.println("destory 1");
	}

	@PreDestroy
	public void destory2() {
		System.out.println("destory 2");
	}

}
