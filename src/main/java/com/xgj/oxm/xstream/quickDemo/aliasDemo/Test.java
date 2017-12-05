package com.xgj.oxm.xstream.quickDemo.aliasDemo;

import com.thoughtworks.xstream.XStream;

/**
 * 
 * 
 * @ClassName: XStreamAliasDemo
 * 
 * @Description: 演示Alias
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年12月5日 上午8:51:29
 */

public class Test {

	public static void main(String[] args) throws Exception {

		// init XStream
		XStream xstream = new XStream();

		// You require xstream-[version].jar, xpp3-[version].jar and
		// xmlpull-[version].jar in the classpath. Xpp3 is a very fast XML
		// pull-parser implementation. If you do not want to include these
		// dependencies, you can use a standard JAXP DOM parser or since Java 6
		// the integrated StAX parser instead:

		// does not require XPP3 library
		// XStream xstream = new XStream(new DomDriver());

		// does not require XPP3 library starting with Java 6
		// XStream xstream = new XStream(new StaxDriver());

		xstream.alias("person", Person.class);
		xstream.alias("phonenumber", PhoneNumber.class);

		Person joe = new Person("Joe", "Walnes");
		joe.setPhone(new PhoneNumber(123, "1234-456"));
		joe.setFax(new PhoneNumber(123, "9999-999"));
		
		// Serializing an object to XML
		String xml = xstream.toXML(joe);
		System.out.println(xml);
		
		// Deserializing an object back from XML
		Person newJoe = (Person) xstream.fromXML(xml);
		System.out.println(newJoe.getFirstname() + "-" + newJoe.getLastname());
	}
}
