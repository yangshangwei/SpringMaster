package com.xgj.dao.transaction.nestedCall.dao;

import com.xgj.dao.transaction.nestedCall.domain.Teacher;

public interface TeacherDao {

	public void addTeacher(Teacher teacher);

	public Teacher getTeacher(int teacherId);

	public void updateTeacher(Teacher teacher);

}
