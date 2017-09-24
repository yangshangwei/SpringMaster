package com.xgj.dao.transaction.annotationTrans.dao;

import com.xgj.dao.transaction.annotationTrans.domain.Student;

public interface StudentDao {

	public void addStudent(Student student);

	public Student getStudent(int studentId);

	public void updateStudent(Student student);

}
