package com.xgj.ioc.inject.construct.jihe.set;

import java.util.Iterator;
import java.util.Set;

public class PetShop {

	private Pets pets;

	public void setPets(Pets pets) {
		this.pets = pets;
	}

	/**
	 * 
	 * 
	 * @Title: petsInfo
	 * 
	 * @Description: 获取注入的set,遍历输出
	 * 
	 * 
	 * @return: void
	 */
	public void petsInfo() {
		Set<Object> set = pets.getSet();
		Iterator<Object> it = set.iterator();
		while (it.hasNext()) {
			System.out.println("PetShop has " + it.next());
		}
	}
}
