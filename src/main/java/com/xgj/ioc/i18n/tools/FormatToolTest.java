package com.xgj.ioc.i18n.tools;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class FormatToolTest {

	public static void main(String[] args) {
		// 中文本地化信息
		Locale locale = Locale.CHINA;
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

		double amt = 123456.78;
		System.out.println(numberFormat.format(amt));
		// 英文本地化信息
		Locale locale2 = Locale.US;
		NumberFormat nFormat = NumberFormat.getCurrencyInstance(locale2);

		double amt2 = 123456.78;
		System.out.println(nFormat.format(amt2));

		// 英文本地化信息
		Locale locale3 = new Locale("en", "US");
		Date date = new Date();
		// 按照本地化的方式对日期进行格式化操作
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,
				locale3);
		System.out.println(dateFormat.format(date));

		// 中文本地化信息
		Locale locale4 = new Locale("zh", "CN");
		Date date2 = new Date();
		// 按照本地化的方式对日期进行格式化操作
		DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.MEDIUM,
				locale4);
		System.out.println(dateFormat2.format(date2));

	}
}
