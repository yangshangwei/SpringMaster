package com.xgj.oxm.xstream.quickDemo.aliasDemo.officeDemo;

import com.thoughtworks.xstream.XStream;

public class AliasPackage {

	public static void main(String[] args) {
		Blog teamBlog = new Blog(new Author("Guilherme Silveira"));

		teamBlog.add(new Entry("first", "My first blog entry."));
		teamBlog.add(new Entry("tutorial",
				"Today we have developed a nice alias tutorial. Tell your friends! NOW!"));

		XStream xstream = new XStream();

		xstream.aliasPackage(
"com.artisan",
				"com.xgj.oxm.xstream.quickDemo.aliasDemo.officeDemo");

		System.out.println(xstream.toXML(teamBlog));

	}

}
