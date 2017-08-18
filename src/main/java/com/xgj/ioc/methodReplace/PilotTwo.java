package com.xgj.ioc.methodReplace;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class PilotTwo implements MethodReplacer {

	public Object reimplement(Object obj, Method method, Object[] args)
			throws Throwable {
		Plane plane = new Plane();
		plane.setBrand("PilotTwo-F35");
		return plane;
	}
}
