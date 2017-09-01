package com.xgj.aop.spring.advisor.aspectJ.function.args;

<<<<<<< HEAD
import org.springframework.stereotype.Component;

@Component
=======
>>>>>>> 75ea043d8f4c2269f6e35dff789a3d42a2bdf259
public class UserServiceExt extends UserService {
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
