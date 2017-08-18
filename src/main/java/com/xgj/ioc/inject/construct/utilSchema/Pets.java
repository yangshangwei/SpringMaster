package com.xgj.ioc.inject.construct.utilSchema;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Pets {

	private Map<Integer, String> petMap;

	private List<String> petList;

	private Set<String> petSet;

	private Properties petProperties;

	public Properties getPetProperties() {
		return petProperties;
	}

	public void setPetProperties(Properties petProperties) {
		this.petProperties = petProperties;
	}

	public Set<String> getPetSet() {
		return petSet;
	}

	public void setPetSet(Set<String> petSet) {
		this.petSet = petSet;
	}

	public List<String> getPetList() {
		return petList;
	}

	public void setPetList(List<String> petList) {
		this.petList = petList;
	}

	public Map<Integer, String> getPetMap() {
		return petMap;
	}

	public void setPetMap(Map<Integer, String> petMap) {
		this.petMap = petMap;
	}

}
