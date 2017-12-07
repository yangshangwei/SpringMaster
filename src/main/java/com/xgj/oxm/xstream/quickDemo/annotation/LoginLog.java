package com.xgj.oxm.xstream.quickDemo.annotation;

import java.io.Serializable;
import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("loginLog")
public class LoginLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@XStreamAsAttribute
	@XStreamAlias("id")
	private int loginLogId;

	@XStreamAsAttribute
	private int userId;

	@XStreamAlias("ip")
	private String ip;

	@XStreamAlias("loginDate")
	@XStreamConverter(DateConverter.class)
	private Date loginDate;

	public int getLoginLogId() {
		return loginLogId;
	}

	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

}
