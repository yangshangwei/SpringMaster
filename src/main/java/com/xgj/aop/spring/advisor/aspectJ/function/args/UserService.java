package com.xgj.aop.spring.advisor.aspectJ.function.args;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	public void addUser(User user) {
		System.out.println("addUser " + user);
	}

	public void modifyUser(User user) {
		System.out.println("modifyUser " + user);
	}

	public void delUser(User user) {
		System.out.println("delUser " + user);
	}
}
