package com.xgj.dao.transaction.xmlTrans.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.dao.transaction.xmlTrans.domain.Student;

public class StudentDaoImplTest {

	ClassPathXmlApplicationContext ctx = null;
	StudentDaoImpl studentDaoImpl = null;

	@Before
	public void initContext() {
		// Æô¶¯Spring ÈÝÆ÷
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/transaction/xmlTrans/conf_txaop_transaction.xml");
		studentDaoImpl = ctx.getBean("studentDaoImpl", StudentDaoImpl.class);
		System.out.println("initContext successfully");
	}

	public void testAddStudent() {
		Student student = new Student();
		student.setAge(16);
		student.setName("S01");
		student.setSex("Male");
		studentDaoImpl.addStudent(student);
	}

	@Test
	public void queryStudentById() {
		Student student = studentDaoImpl.getStudent(1);
		System.out.println("Student Info¡¾ name:" + student.getName()
				+ " , age:" + student.getAge() + " ,sex:" + student.getSex()
				+ "¡¿");
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}
}
