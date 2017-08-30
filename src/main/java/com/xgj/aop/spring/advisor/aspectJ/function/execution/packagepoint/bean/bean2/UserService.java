package com.xgj.aop.spring.advisor.aspectJ.function.execution.packagepoint.bean.bean2;

public class UserService {

	public void addUserInfo(String userName) {
		System.out.println("addUserInfo " + userName);
	}

	public void modifyUserInfo(String userName) {
		System.out.println("modifyUserInfo " + userName);
	}

	public void delUserInfo(String userName) {
		System.out.println("delUserInfo " + userName);
	}
}
