package com.xgj.oxm.xstream.quickDemo.aliasDemo.officeDemo;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class AuthorConverter implements SingleValueConverter {

	/**
	 * tells XStream which types it can deal with
	 */
	public boolean canConvert(Class type) {
		return type.equals(Author.class);
	}

	/**
	 * extract a String from an Author
	 */
	public String toString(Object obj) {
		return ((Author) obj).getName();
	}

	/**
	 * takes a String and returns an Author
	 */
	public Object fromString(String name) {
		return new Author(name);
	}
}
