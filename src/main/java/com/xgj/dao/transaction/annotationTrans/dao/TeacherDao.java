package com.xgj.dao.transaction.annotationTrans.dao;

import org.springframework.stereotype.Component;

import com.xgj.dao.transaction.annotationTrans.domain.Teacher;

public interface TeacherDao {

	public void addTeacher(Teacher teacher);

	public Teacher getTeacher(int teacherId);

	public void updateTeacher(Teacher teacher);

}
