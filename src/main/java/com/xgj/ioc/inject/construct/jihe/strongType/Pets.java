package com.xgj.ioc.inject.construct.jihe.strongType;

import java.util.HashMap;
import java.util.Map;

public class Pets {

	private Map<Integer, String> map = new HashMap<Integer, String>();

	public Map<Integer, String> getMap() {
		return map;
	}

	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}

}
