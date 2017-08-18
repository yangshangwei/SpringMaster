package com.xgj.ioc.beans;

public class Boss {

	private String name;
	private String sex;
	private int age;
	private Plane plane ;
	
	
	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void introduce() {
		System.out.println("Boss Information¡¾name:" + name + ",sex:" + sex + ",age:" + age +"¡¿" );
		plane.info();
	}

}
