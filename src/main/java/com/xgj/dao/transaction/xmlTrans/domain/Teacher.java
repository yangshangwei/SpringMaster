package com.xgj.dao.transaction.xmlTrans.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Teacher implements Serializable {

	private static final long serialVersionUID = 12L;
	private int teacherId;
	private String name;
	private int age;
	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
