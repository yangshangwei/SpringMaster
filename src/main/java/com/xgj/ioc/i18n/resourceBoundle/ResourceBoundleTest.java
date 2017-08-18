package com.xgj.ioc.i18n.resourceBoundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBoundleTest {

	public static void main(String[] args) {

		ResourceBundle resBundle = ResourceBundle.getBundle("i18n/resource",
				Locale.getDefault());
		System.out.println(resBundle.getString("greeting.common"));
		System.out.println(resBundle.getString("greeting.morning"));
		System.out.println(resBundle.getString("greeting.afternoon"));

		ResourceBundle resBundle2 = ResourceBundle.getBundle("i18n/resource",
				Locale.US);
		System.out.println(resBundle2.getString("greeting.common"));
		System.out.println(resBundle2.getString("greeting.morning"));
		System.out.println(resBundle2.getString("greeting.afternoon"));
	}
}
