package com.xgj.dao.transaction.nestedCall.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.xgj.dao.transaction.nestedCall.dao.BaseDao;
import com.xgj.dao.transaction.nestedCall.dao.TeacherDao;
import com.xgj.dao.transaction.nestedCall.domain.Teacher;

/**
 * 
 * 
 * @ClassName: TeacherDaoImpl
 * 
 * @Description: @Repository标注的DAO层
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月24日 下午5:09:03
 */

@Repository
public class TeacherDaoImpl extends BaseDao implements TeacherDao {
	private Logger logger = Logger.getLogger(TeacherDaoImpl.class);

	private static final String addTeacherSQL = "insert into teacher(id,name,age,sex) values(teacher_id_seq.nextval,?,?,?)";
	private static final String queryTeacherByIdSQL = "select name ,age ,sex from teacher where id = ?";
	private static final String updateTeacherByIdSQL = "update teacher set  name = ? ,age = ? ,sex = ?  where id = ?";

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
		jdbcTemplate.update(updateTeacherByIdSQL, teacher.getName(),
				teacher.getAge(), teacher.getSex(), teacher.getTeacherId());
		logger.info("updateTeacher successfully");
	}
}
