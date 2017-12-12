package com.xgj.oxm.xstream.quickDemo.persistence;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

/**
 * 
 * 
 * @ClassName: PersistenceArrayListConverter
 * 
 * @Description: 自定义转换器
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年12月12日 下午7:22:29
 */

public class PersistenceArrayListConverter implements Converter {
	private XStream xstream;

	public PersistenceArrayListConverter(XStream xstream) {
		this.xstream = xstream;
	}

	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		File dir = new File(System.getProperty("user.home"), "documents");
		XmlArrayList list = new XmlArrayList(new FilePersistenceStrategy(dir, xstream));
		context.convertAnother(dir);
		list.addAll((Collection) source); // generate the external files
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		File directory = (File) context.convertAnother(null, File.class);
		XmlArrayList persistentList = new XmlArrayList(new FilePersistenceStrategy(directory, xstream));
		ArrayList list = new ArrayList(persistentList); // read all files
		persistentList.clear(); // remove files
		return list;
	}

	public boolean canConvert(Class type) {
		return type == ArrayList.class;
	}

}
