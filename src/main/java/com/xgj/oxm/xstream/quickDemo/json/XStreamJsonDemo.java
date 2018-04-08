package com.xgj.oxm.xstream.quickDemo.json;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.xgj.oxm.xstream.quickDemo.domain.LoginLog;
import com.xgj.oxm.xstream.quickDemo.domain.User;

/**
 * 
 * 
 * @ClassName: XStreamJsonDemo
 * 
 * @Description: XStreamJsonDemo
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年12月12日 下午7:40:07
 */
public class XStreamJsonDemo {


	private static XStream xstream;

	/**
	 * 
	 * 
	 * @Title: toJsonByJettisonMappedXmlDriver
	 * 
	 * @Description: 连续的没有分割的JSON串
	 * 
	 * @throws Exception
	 * 
	 * @return: void
	 */
	public static void toJsonByJettisonMappedXmlDriver() throws Exception {
		User user = getUser();
		FileOutputStream outputSteam = new FileOutputStream("D:\\JettisonMappedSample.json");
		OutputStreamWriter writer = new OutputStreamWriter(outputSteam, Charset.forName("UTF-8"));
		xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.alias("user", User.class);
		xstream.toXML(user, writer);
		System.out.println("==============WithoutFormat===============");
		System.out.println(xstream.toXML(user));
	}

	/**
	 * 
	 * 
	 * @Title: toJsonByJsonHierarchicalStreamDriver
	 * 
	 * @Description: 格式化良好的JSON串
	 * 
	 * @throws Exception
	 * 
	 * @return: void
	 */
	public static void toJsonByJsonHierarchicalStreamDriver() throws Exception {
		User user = getUser();
		FileOutputStream outputSteam = new FileOutputStream("D:\\JsonByJsonHierarchicalSample.json");
		OutputStreamWriter writer = new OutputStreamWriter(outputSteam, Charset.forName("UTF-8"));
		xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("user", User.class);
		xstream.toXML(user, writer);
		System.out.println("==============WithFormat===============");
		System.out.println(xstream.toXML(user));
	}

	public static User jsonToObject() throws Exception {
		String json = "{\"user\":{\"id\":1,\"userName\":\"xstream\",\"credits\":0,\"logs\":[{\"com.xgj.oxm.xstream.quickDemo.domain.LoginLog\":[{\"loginLogId\":0,\"userId\":0,\"ip\":\"192.168.1.91\",\"loginDate\":\"2017-12-12 11:49:05.320 UTC\"},{\"loginLogId\":0,\"userId\":0,\"ip\":\"127.0.0.1\",\"loginDate\":\"2017-12-12 11:49:05.320 UTC\"}]}]}}";
		xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("user", User.class);
		User user = (User) xstream.fromXML(json);
		return user;
	}


	public static void main(String[] args) throws Exception {

		toJsonByJettisonMappedXmlDriver();
		toJsonByJsonHierarchicalStreamDriver();

		User u = jsonToObject();
		for (LoginLog log : u.getLogs()) {
			if (log != null) {
				System.out.println("IP: " + log.getIp());
				System.out.println("LoginDate: " + log.getLoginDate());
			}
		}
	}

	public static User getUser() {
		LoginLog log1 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());
		LoginLog log2 = new LoginLog();
		log2.setIp("127.0.0.1");
		log2.setLoginDate(new Date());
		User user = new User();
		user.setId(1);
		user.setUserName("xstream");
		user.addLoginLog(log1);
		user.addLoginLog(log2);
		return user;
	}
}
