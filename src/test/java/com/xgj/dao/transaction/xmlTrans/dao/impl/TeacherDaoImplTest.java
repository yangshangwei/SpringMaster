package com.xgj.dao.transaction.xmlTrans.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.dao.transaction.xmlTrans.domain.Teacher;

public class TeacherDaoImplTest {

	ClassPathXmlApplicationContext ctx = null;
	TeacherDaoImpl teacherDaoImpl = null;

	@Before
	public void initContext() {
		// Æô¶¯Spring ÈÝÆ÷
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/transaction/xmlTrans/conf_txaop_transaction.xml");
		teacherDaoImpl = ctx.getBean("teacherDaoImpl", TeacherDaoImpl.class);
		System.out.println("initContext successfully");
	}

	public void testAddTeacher() {
		Teacher teacher = new Teacher();
		teacher.setAge(18);
		teacher.setName("Xiao");
		teacher.setSex("Male");
		teacherDaoImpl.addTeacher(teacher);
	}

	@Test
	public void queryTeacherById() {
		Teacher teacher = teacherDaoImpl.getTeacher(2);
		System.out.println("Teacher Info¡¾ name:" + teacher.getName()
				+ " , age:" + teacher.getAge() + " ,sex:" + teacher.getSex()
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
