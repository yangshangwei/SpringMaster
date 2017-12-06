package com.xgj.oxm.xstream.quickDemo.convert;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import com.thoughtworks.xstream.XStream;
import com.xgj.oxm.xstream.quickDemo.domain.LoginLog;
import com.xgj.oxm.xstream.quickDemo.domain.User;

public class XStreamConverterDemo {

	private static XStream xstream;

	static {
		// 创建一个Xstream实例，使用默认的XPP解析器
		xstream = new XStream();

		// (1)设置类别名，修改默认的全限定名的名称
		xstream.alias("user", User.class);
		xstream.alias("loginLog", LoginLog.class);

		// (2)设置类成员别名 <id>1</id> 改为<userId>1</userId>
		xstream.aliasField("userId", User.class, "id");

		// (3)把LoginLog的userId属性视为xml属性，默认为xml的元素
		xstream.aliasAttribute(LoginLog.class, "userId", "id");
		xstream.useAttributeFor(LoginLog.class, "userId");

		// (4)去掉集合类型生成XML的父节点，即忽略xml中的<logs></logs>标记
		xstream.addImplicitCollection(User.class, "logs");

		// 注册转换器
		xstream.registerConverter(new DateConverter(Locale.CHINESE));
	}

	/**
	 * 
	 * 
	 * @Title: getUser
	 * 
	 * @Description: 初始化转换对象
	 * 
	 * @return
	 * 
	 * @return: User
	 * @throws ParseException
	 */
	public static User getUser() throws ParseException {
		LoginLog log = new LoginLog();
		log.setIp("127.0.0.1");
		log.setLoginLogId(99);
		log.setUserId(1);
		log.setLoginDate(new Date());

		LoginLog log2 = new LoginLog();
		log2.setIp("192.168.1.1");
		log2.setLoginLogId(22);
		log2.setUserId(2);
		log2.setLoginDate(new Date());

		User user = new User();
		user.setId(1);
		user.setUserName("Artisan");
		user.setPassword("artisan");
		user.setCredits(1000);
		user.setLastVisit(new Date());

		user.addLoginLog(log);
		user.addLoginLog(log2);
		return user;
	}

	/**
	 * 
	 * 
	 * @Title: objectToXml
	 * 
	 * @Description: Java对象转换成XML
	 * 
	 * @throws Exception
	 * 
	 * @return: void
	 */
	public static void objectToXml() throws Exception {
		// 获取转换的User对象实例
		User user = getUser();
		// 输出内容到控制台,查看一下
		System.out.println(xstream.toXML(user));
	}



	public static void main(String[] args) throws Exception {
		objectToXml();
	}
}
