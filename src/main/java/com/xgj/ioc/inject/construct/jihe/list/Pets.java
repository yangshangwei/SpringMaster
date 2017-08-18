package com.xgj.ioc.inject.construct.jihe.list;

import java.util.ArrayList;
import java.util.List;

public class Pets {

	private List petsList = new ArrayList();

	public List getPetsList() {
		return petsList;
	}

	public void setPetsList(List petsList) {
		this.petsList = petsList;
	}

}
