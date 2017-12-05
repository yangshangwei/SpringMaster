package com.xgj.oxm.xstream.quickDemo.aliasDemo;

/**
 * 
 * 
 * @ClassName: Person
 * 
 * @Description: Create classes to be serialized , 构造函数和set/get方法
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年12月5日 上午8:50:30
 */
public class Person {
	private String firstname;
	private String lastname;
	private PhoneNumber phone;
	private PhoneNumber fax;

	public Person(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	public PhoneNumber getFax() {
		return fax;
	}

	public void setFax(PhoneNumber fax) {
		this.fax = fax;
	}

}
