package com.xgj.oxm.xstream.quickDemo.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 
 * 
 * @ClassName: User
 * 
 * @Description: 使用注解
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年12月6日 下午9:17:11
 */

@XStreamAlias("user")
public class User {

	@XStreamAsAttribute
	@XStreamAlias("userId")
	private int id;

	@XStreamAlias("userName")
	private String userName;

	@XStreamAlias("password")
	private String password;

	@XStreamAlias("credits")
	private int credits;

	@XStreamAlias("lastIp")
	private String lastIp;

	@XStreamConverter(DateConverter.class)
	private Date lastVisit;

	@XStreamImplicit
	private List<LoginLog> logs;

	private Map datas;

	public List<LoginLog> getLogs() {
		return logs;
	}

	public void setLogs(List logs) {
		this.logs = logs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
