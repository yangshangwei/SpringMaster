package com.xgj.ioc.i18n.resourceBoundle;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBoundleWithFormatTest {
	public static void main(String[] args) {

		// 加载本地资源
		ResourceBundle reBundle1 = ResourceBundle.getBundle(
				"i18n/fmt_resource", Locale.CHINA);

		ResourceBundle reBundle2 = ResourceBundle.getBundle(
				"i18n/fmt_resource", Locale.US);

		Object[] params = { "XiaoGongJiang", new GregorianCalendar().getTime() };

		// 用本地化对象进行格式化
		String greetingCommonCH = new MessageFormat(
				reBundle1.getString("greeting.common"), Locale.CHINA)
				.format(params);

		String greetingMorningCH = new MessageFormat(
				reBundle1.getString("greeting.morning"), Locale.CHINA)
				.format(params);

		String greetingAfternoonCH = new MessageFormat(
				reBundle1.getString("greeting.afternoon"), Locale.CHINA)
				.format(params);

		System.out.println(greetingCommonCH);
		System.out.println(greetingMorningCH);
		System.out.println(greetingAfternoonCH);

		String greetingCommonEN = new MessageFormat(
				reBundle2.getString("greeting.common"), Locale.US)
				.format(params);

		String greetingMorningEN = new MessageFormat(
				reBundle2.getString("greeting.morning"), Locale.US)
				.format(params);

		String greetingAfternoonEN = new MessageFormat(
				reBundle2.getString("greeting.afternoon"), Locale.US)
				.format(params);

		System.out.println(greetingCommonEN);
		System.out.println(greetingMorningEN);
		System.out.println(greetingAfternoonEN);
	}
}
