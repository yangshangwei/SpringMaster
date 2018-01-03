package com.xgj.aop.spring.advisor.aspectJ.function.args;

import org.springframework.stereotype.Component;

@Component
public class UserServiceExt {
	public void addUser(User user) {
		System.out.println("子类 addUser " + user);
	}

	public void modifyUser(User user) {
		System.out.println("子类 modifyUser " + user);
	}

	public void delUser(User user) {
		System.out.println("子类 delUser " + user);
	}
}
