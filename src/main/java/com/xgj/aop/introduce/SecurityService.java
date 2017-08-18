package com.xgj.aop.introduce;

public interface SecurityService {
	boolean checkAccess(User user, String service);
}
