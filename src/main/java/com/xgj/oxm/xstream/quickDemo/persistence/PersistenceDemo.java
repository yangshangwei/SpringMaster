package com.xgj.oxm.xstream.quickDemo.persistence;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

/**
 * 
 * 
 * @ClassName: PersistenceDemo
 * 
 * @Description: TODO
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年12月12日 上午10:06:29
 */

public class PersistenceDemo {


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		List<Artisan> artisans = new ArrayList<Artisan>();

		// （1）实例化需要持久化的对象
		Artisan artisan1 = new Artisan("artisan1", "male", 20);
		Artisan artisan2 = new Artisan("artisan2", "female", 40);
		// 加入List中
		artisans.add(artisan1);
		artisans.add(artisan2);

		System.out.println(artisans.size());

		// （2）创建持久化策略 （必须是目录，否则报错--生成的xml保存的目录）
		File file = new File("D://");
		PersistenceStrategy strategy = new FilePersistenceStrategy(file);

		// （3）持久化集合对象
		List list = new XmlArrayList(strategy);
		list.addAll(artisans);

		// (4) 验证下
		XStream xstream = new XStream();
		xstream.registerConverter(new PersistenceArrayListConverter(xstream));
		String xml = xstream.toXML(artisans);
		System.out.println(xml);

	}

}
