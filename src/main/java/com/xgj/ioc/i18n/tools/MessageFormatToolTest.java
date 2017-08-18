package com.xgj.ioc.i18n.tools;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MessageFormatToolTest {

	public static void main(String[] args) {
		// (1)格式化信息串
		String pattern1 = "{0},你好！你与{1}支付了货款{2}元";
		String pattern2 = "At {1,time,short} on {1,date,long},{0} paid {2,number,currency}";
		// (2)用于动态替换占位符的参数
		Object[] params = { "XiaoGongJiang", new GregorianCalendar().getTime(),
				200 };
		// (3)使用默认的本地化对象格式化信息
		String msg1 = MessageFormat.format(pattern1, params);
		// (4)使用指定的本地化对象格式化信息
		MessageFormat messageFormat = new MessageFormat(pattern2, Locale.US);
		String msg2 = messageFormat.format(params);

		System.out.println(msg1);
		System.out.println(msg2);

	}
}
