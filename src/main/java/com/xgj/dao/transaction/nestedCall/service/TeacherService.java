package com.xgj.dao.transaction.nestedCall.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgj.dao.transaction.nestedCall.dao.TeacherDao;
import com.xgj.dao.transaction.nestedCall.domain.Student;
import com.xgj.dao.transaction.nestedCall.domain.Teacher;

/**
 * 
 * 
 * @ClassName: TeacherService
 * 
 * @Description: @Service标注的service层 继承BaseService
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月24日 下午4:56:35
 */

@Service
public class TeacherService extends BaseService {

	Logger logger = Logger.getLogger(TeacherService.class);

	private TeacherDao teacherDao;
	private StudentService studentService;

	@Autowired
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	/**
	 * 
	 * 
	 * @Title: init
	 * 
	 * @Description: 改方法嵌套调用了本类的其他方法以及其他类的方法
	 * 
	 * 
	 * @return: void
	 */
	public void doSomething() {
		logger.info("before TeacherService#udpateTeacherInfo");
		// 调用本类的其他方法
		udpateTeacherInfo(simulateTeacher());
		logger.info("after TeacherService#udpateTeacherInfo");

		// 调用其他类的方法
		logger.info("before StudentService#updateSutdent");
		studentService.updateSutdent(simulateStudent());
		logger.info("after StudentService#updateSutdent");

	}

	public void udpateTeacherInfo(Teacher teacher) {
		teacherDao.updateTeacher(teacher);
	}

	/**
	 * 
	 * 
	 * @Title: simulateTeacher
	 * 
	 * @Description: 模拟获取一个teacher实例
	 * 
	 * @return
	 * 
	 * @return: Teacher
	 */
	private Teacher simulateTeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("FTT");
		teacher.setAge(88);
		teacher.setSex("FF");
		teacher.setTeacherId(2);
		return teacher;
	}

	private Student simulateStudent() {
		Student student = new Student();
		student.setName("FSS");
		student.setAge(22);
		student.setSex("MM");
		student.setStudentId(2);
		return student;
	}

}
