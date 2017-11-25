package com.xgj.oxm.xstream.quickDemo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int userId;
	private String userName;
	private String password;
	private int credits;
	private String lastIp;
	private Date lastVisit;
	private List<LoginLog> logs;
	private Map datas;

	public List<LoginLog> getLogs() {
		return logs;
	}

	public void setLogs(List logs) {
		this.logs = logs;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public void addLoginLog(LoginLog log) {
		if (this.logs == null) {
			logs = new ArrayList<LoginLog>();
		}
		logs.add(log);
	}

	public Map getDatas() {
		return datas;

	}

	public void setDatas(Map datas) {
		this.datas = datas;
	}


}
