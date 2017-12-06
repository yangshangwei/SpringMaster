package com.xgj.oxm.xstream.quickDemo.aliasDemo.officeDemo;

import java.util.ArrayList;
import java.util.List;

public class Blog {

	// Author
	private Author writer;

	// Entry集合
	private List<Entry> entries = new ArrayList<Entry>();

	/**
	 * 
	 * 
	 * @Title:Blog
	 * 
	 * @Description:构造函数
	 * 
	 * @param writer
	 */
	public Blog(Author writer) {
		this.writer = writer;
	}

	/**
	 * 
	 * 
	 * @Title: add
	 * 
	 * @Description: 添加Entry
	 * 
	 * @param entry
	 * 
	 * @return: void
	 */
	public void add(Entry entry) {
		entries.add(entry);
	}

	/**
	 * 
	 * 
	 * @Title: getContent
	 * 
	 * @Description: 获取Entry List集合
	 * 
	 * @return
	 * 
	 * @return: List<Entry>
	 */
	public List<Entry> getContent() {
		return entries;
	}
}
