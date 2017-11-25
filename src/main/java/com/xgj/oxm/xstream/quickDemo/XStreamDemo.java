package com.xgj.oxm.xstream.quickDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xgj.oxm.xstream.quickDemo.domain.LoginLog;
import com.xgj.oxm.xstream.quickDemo.domain.User;

public class XStreamDemo {

	private static XStream xstream;

	static {
		// 创建一个Xstream实例，并指定一个XML解析器
		xstream = new XStream(new DomDriver());
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

		User user = new User();
		user.setUserId(1);
		user.setUserName("Artisan");
		user.setPassword("artisan");
		user.setCredits(1000);
		user.setLastVisit(new Date());
		user.addLoginLog(log);

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

		// 实例化一个文件输出流
		FileOutputStream os = new FileOutputStream("D://XstreamDemo.xml");

		// 将User对象转换为XML，并保存到指定的文件
		xstream.toXML(user, os);

		System.out.println("objectToXml successfully");
	}

	/**
	 * 
	 * 
	 * @Title: XmlToObject
	 * 
	 * @Description: Xml转Java对象
	 * 
	 * @throws Exception
	 * 
	 * @return: void
	 */
	public static void XmlToObject() throws Exception {
		// 实例化文件输入流
		FileInputStream in = new FileInputStream("D://XstreamDemo.xml");
		
		// 将xml文件输入流转化为对象
		User user = (User) xstream.fromXML(in);
		
		// 遍历
		for (LoginLog log : user.getLogs()) {
			System.out.println("访问时间:" + log.getLoginDate());
			System.out.println("访问IP:" + log.getIp());
		}

	}

	public static void main(String[] args) throws Exception {
		objectToXml();
		System.out.println("=====================================");
		XmlToObject();
	}
}
