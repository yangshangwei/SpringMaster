package com.xgj.ioc.inject.construct.utilSchema;

import java.util.Iterator;
import java.util.Map;
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
	 * @Description: 获取容器注入的Map，遍历输出
	 * 
	 * 
	 * @return: void
	 */
	public void petsInfo_Map() {

		Map<Integer, String> map = pets.getPetMap();

		for (Map.Entry<Integer, String> entry : map.entrySet()) {

			System.out.println("编号Key = " + entry.getKey() + ",品种Value = "
					+ entry.getValue());
		}
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
	public void petsInfo_List() {
		for (int i = 0; i < pets.getPetList().size(); i++) {
			System.out.println("PetShop has " + pets.getPetList().get(i));
		}
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
	public void petsInfo_Set() {
		Set<String> set = pets.getPetSet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println("PetShop has " + it.next());
		}
	}

	/**
	 * 
	 * 
	 * @Title: petsInfo
	 * 
	 * @Description: 获取容器注入的Properties，遍历输出
	 * 
	 * 
	 * @return: void
	 */
	public void petsInfo_Properties() {

		Map<Object, Object> map = pets.getPetProperties();

		for (Map.Entry<Object, Object> entry : map.entrySet()) {

			System.out.println("编号Key = " + entry.getKey() + ",品种Value = "
					+ entry.getValue());

		}
	}
}
