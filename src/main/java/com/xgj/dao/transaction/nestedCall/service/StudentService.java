package com.xgj.dao.transaction.nestedCall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgj.dao.transaction.nestedCall.dao.StudentDao;
import com.xgj.dao.transaction.nestedCall.domain.Student;

/**
 * 
 * 
 * @ClassName: StudentService
 * 
 * @Description: @Service标注的service层
 * 
 *               StudentService继承BaseService才能在日志中看到 Participating in existing
 *               transaction
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月24日 下午7:47:09
 */

@Service
public class StudentService extends BaseService {

	private StudentDao studentDao;

	/**
	 * 
	 * 
	 * @Title: setStudentDao
	 * 
	 * @Description: @Autowired通过set方法注入studentDao
	 * 
	 * @param studentDao
	 * 
	 * @return: void
	 */

	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	/**
	 * 
	 * 
	 * @Title: addStudent
	 * 
	 * @Description: 增加学生
	 * 
	 * @param student
	 * 
	 * @return: void
	 */
	public void updateSutdent(Student student) {
		studentDao.updateStudent(student);
	}

}
