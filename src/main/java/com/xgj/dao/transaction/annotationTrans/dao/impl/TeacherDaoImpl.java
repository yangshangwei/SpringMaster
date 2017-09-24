package com.xgj.dao.transaction.annotationTrans.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.xgj.dao.transaction.annotationTrans.dao.BaseDao;
import com.xgj.dao.transaction.annotationTrans.dao.TeacherDao;
import com.xgj.dao.transaction.annotationTrans.domain.Teacher;

@Repository
public class TeacherDaoImpl extends BaseDao implements TeacherDao {
	private Logger logger = Logger.getLogger(TeacherDaoImpl.class);

	private static final String addTeacherSQL = "insert into teacher(id,name,age,sex) values(teacher_id_seq.nextval,?,?,?)";
	private static final String queryTeacherByIdSQL = "select name ,age ,sex from teacher where id = ?";

	@Override
	public void addTeacher(final Teacher teacher) {

		jdbcTemplate.update(addTeacherSQL, teacher.getName(), teacher.getAge(),
				teacher.getSex());
		logger.info("TeacherDaoImpl#addTeacher successfully");
	}

	@Override
	public Teacher getTeacher(int teacherId) {

		logger.info("TeacherID:" + teacherId);

		final Teacher teacher = new Teacher();
		jdbcTemplate.query(queryTeacherByIdSQL, new Object[] { teacherId },
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						teacher.setAge(rs.getInt("age"));
						teacher.setName(rs.getString("name"));
						teacher.setSex(rs.getString("sex"));
					}
				});
		return teacher;
	}

	@Override
	public void updateTeacher(Teacher teacher) {

	}

}
