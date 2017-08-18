package com.xgj.ioc.inject.construct.jihe.list;

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
	 * @Description: 获取容器注入的List，遍历输出
	 * 
	 * 
	 * @return: void
	 */
	public void petsInfo() {
		for (int i = 0; i < pets.getPetsList().size(); i++) {
			System.out.println("PetShop has " + pets.getPetsList().get(i));
		}
	}

}
