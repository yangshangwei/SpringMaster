package com.xgj.oxm.xstream.quickDemo.streamObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.xgj.oxm.xstream.quickDemo.domain.LoginLog;
import com.xgj.oxm.xstream.quickDemo.domain.User;

public class ObjectStreamDemo {

	private static XStream xstream;

	static {
		xstream = new XStream();
	}

	/**
	 * 
	 * 
	 * @Title: objectToXml
	 * 
	 * @Description: JAVA对象转化为XML
	 * 
	 * @throws Exception
	 * 
	 * @return: void
	 */
	public void objectToXml() throws Exception {
		// （1）实例化序列化对象
		User user = getUser();
		// （2）创建一个PrintWriter对象，用于输出。
		PrintWriter pw = new PrintWriter("D:\\ObjectStreamSample.xml");
		// （3）创建一个HierarchicalStreamWriter的实现类来创建输出
		PrettyPrintWriter ppw = new PrettyPrintWriter(pw);
		// （4）创建对象输出流
		ObjectOutputStream out = xstream.createObjectOutputStream(ppw);
		out.writeObject(user);
		out.close();
	}

	/**
	 * 
	 * 
	 * @Title: xmlToObject
	 * 
	 * @Description: XML转化为JAVA对象
	 * 
	 * @return
	 * @throws Exception
	 * 
	 * @return: User
	 */
	public User xmlToObject() throws Exception {
		// （1）我们需要通过对象流进行输入操作，需要FileReader和BufferedReader
		FileReader fr = new FileReader("D:\\ObjectStreamSample.xml");
		BufferedReader br = new BufferedReader(fr);
		// （2）创建对象输入流
		ObjectInputStream input = xstream.createObjectInputStream(br);
		// （3）创建对象，通过ObjectInputStream中的readObject()方法将对象从XML文件中读取出来。
		User user = (User) input.readObject();
		return user;

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
	 */
	public static User getUser() {
		LoginLog log1 = new LoginLog();
		LoginLog log2 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());
		log2.setIp("192.168.1.92");
		log2.setLoginDate(new Date());
		User user = new User();
		user.setId(1);
		user.setUserName("xstream");
		user.addLoginLog(log1);
		user.addLoginLog(log2);
		return user;
	}

	public static void main(String[] args) throws Exception {
		ObjectStreamDemo converter = new ObjectStreamDemo();
		converter.objectToXml();
		User u = converter.xmlToObject();
		for (LoginLog log : u.getLogs()) {
			if (log != null) {
				System.out.println("访问IP: " + log.getIp());
				System.out.println("访问时间: " + log.getLoginDate());
			}
		}

	}

}