package com.xgj.dao.transaction.annotationTrans.Service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgj.dao.transaction.annotationTrans.domain.Student;
import com.xgj.dao.transaction.annotationTrans.domain.Teacher;

public class ManagerServiceTest {

	ClassPathXmlApplicationContext ctx = null;
	ManagerService managerService = null;

	@Before
	public void initContext() {
		// Æô¶¯Spring ÈÝÆ÷
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/transaction/annotationTrans/conf_tx_annotation.xml");
		managerService = ctx.getBean("managerService", ManagerService.class);
		System.out.println("initContext successfully");
	}

	@Test
	public void testAddTeacherAndStudentInOneTransaction() {

		Teacher teacher = new Teacher();
		Student student = new Student();

		teacher.setAge(40);
		teacher.setName("TeacherOne");
		teacher.setSex("Female");

		student.setAge(16);
		student.setName("StudentOne");
		student.setSex("Male");

		managerService.addTeacherAndStudent(teacher, student);
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}

}
