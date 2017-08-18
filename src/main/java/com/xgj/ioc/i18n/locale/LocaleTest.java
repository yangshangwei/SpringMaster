package com.xgj.ioc.i18n.locale;

import java.util.Locale;

public class LocaleTest {

	public static void main(String[] args) {
		// (1)带有语言和国家/地区信息的本地化对象
		Locale locale1 = new Locale("zh", "CN");
		System.out.println("Locale(\"zh\", \"CN\"):" + locale1);

		// (2)只带有语言信息的本地化对象
		Locale locale2 = new Locale("zh");
		System.out.println("Locale(\"zh\"):" + locale2);

		// (3)等同于Locale("zh", "CN")
		Locale locale3 = Locale.CHINA;
		System.out.println("Locale.CHINA:" + locale3);

		// (4)等同于Locale("zh")
		Locale locale4 = Locale.CHINESE;
		System.out.println("Locale.CHINESE:" + locale4);

		// (5)获取本地系统默认的本地化对象
		Locale locale5 = Locale.getDefault();
		System.out.println("Locale.getDefault():" + locale5);
	}
}
