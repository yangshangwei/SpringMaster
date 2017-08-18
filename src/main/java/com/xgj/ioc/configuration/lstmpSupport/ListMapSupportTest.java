package com.xgj.ioc.configuration.lstmpSupport;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ListMapSupportTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/ioc/configuration/lstmpSupport/beans.xml");
		// 从容器中获取bean
		MyComponent myComponent = ctx.getBean("myComponent", MyComponent.class);
		// 获取Map集合
		Map<String, Plugin> map = myComponent.getPluginMap();
		// Map遍历key和value
		for (Entry<String, Plugin> entry : map.entrySet()) {
			System.out.println("key:" + entry.getKey());
			System.out.println("value:" + entry.getValue());
		}
		// 获取list集合
		List<Plugin> list = myComponent.getPlugins();
		// 遍历list
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list中的元素" + i + "为" + list.get(i));
		}
	}
}
