package com.xgj.aop.spring.advisor.aspectJ.function.args;

import org.springframework.stereotype.Component;

@Component
public class UserServiceExt {
	public void addUser(User user) {
		System.out.println("入参为user的类  addUser " + user);
	}

	public void modifyUser(User user) {
		System.out.println("入参为user的类   modifyUser " + user);
	}

	public void delUser(User user) {
		System.out.println("入参为user的类  delUser " + user);
	}

	/**
	 * 
	 * 
	 * @Title: addArtisanTT
	 * 
	 * @Description: 入参为ArtisanTT
	 * 
	 * @param artisan
	 * 
	 * @return: void
	 */
	public void addArtisanTT(ArtisanTT artisan) {
		System.out.println("addArtisanTT " + artisan);
	}

	public void modifyArtisanTT(ArtisanTT artisan) {
		System.out.println("modifyArtisanTT " + artisan);
	}

	public void delArtisanTT(ArtisanTT artisan) {
		System.out.println("delArtisanTT " + artisan);
	}
}
