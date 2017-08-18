package com.xgj.ioc.inject.construct.jihe.strongType;

import java.util.Map;

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
	 * @Description: 获取容器注入的Map，遍历输出
	 * 
	 * 
	 * @return: void
	 */
	public void petsInfo() {

		Map<Integer, String> map = pets.getMap();

		for (Map.Entry<Integer, String> entry : map.entrySet()) {

			System.out.println("编号Key = " + entry.getKey() + ",品种Value = "
					+ entry.getValue());

		}
	}
}
