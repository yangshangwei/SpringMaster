package com.xgj.dao.transaction.xmlTrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgj.dao.transaction.xmlTrans.dao.StudentDao;
import com.xgj.dao.transaction.xmlTrans.dao.TeacherDao;
import com.xgj.dao.transaction.xmlTrans.domain.Student;
import com.xgj.dao.transaction.xmlTrans.domain.Teacher;

/**
 * 
 * 
 * @ClassName: ManagerService
 * 
 * @Description: @Service标注的Service层
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月22日 下午10:18:31
 */

@Service
public class ManagerService {

	private TeacherDao teacherDao;
	private StudentDao studentDao;

	/**
	 * 
	 * 
	 * @Title: addTeacherAndStudent
	 * 
	 * @Description: 配置文件中<tx:method name="add*" rollback-for="Exception"/>
	 *               我们故意经写入student表时，让其异常，看下teacher是否回滚--OK 都没有写入，说明在一个事务中
	 *               如果有去掉<tx:method name="add*"
	 *               rollback-for="Exception"/>，经验证Teacher可成功增加，说明不在一个事务中
	 * 
	 *               rollback-for="Exception"这个可不加，默认是回滚的
	 * @param teacher
	 * @param student
	 * 
	 * @return: void
	 */
	public void addTeacherAndStudent(Teacher teacher, Student student) {
		teacherDao.addTeacher(teacher);
		studentDao.addStudent(student);
	}

	public void updateTeacher(Teacher teacher) {
		teacherDao.updateTeacher(teacher);
	}

	public void getTeacherById(int teacherId) {
		teacherDao.getTeacher(teacherId);
	}

	@Autowired
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
}
