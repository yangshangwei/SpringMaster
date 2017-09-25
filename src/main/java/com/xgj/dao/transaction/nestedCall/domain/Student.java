package com.xgj.dao.transaction.nestedCall.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private int studentId;
	private String name;
	private int age;
	private String sex;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
