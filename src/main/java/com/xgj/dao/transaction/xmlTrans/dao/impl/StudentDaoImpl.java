package com.xgj.dao.transaction.xmlTrans.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.xgj.dao.transaction.xmlTrans.dao.BaseDao;
import com.xgj.dao.transaction.xmlTrans.dao.StudentDao;
import com.xgj.dao.transaction.xmlTrans.domain.Student;

@Component
public class StudentDaoImpl extends BaseDao implements StudentDao {

	private Logger logger = Logger.getLogger(TeacherDaoImpl.class);
	// 故意写错表名,让其抛出异常,验证和addTeacher在一个事务中
	private static final String addStudentSQL = "insert into student1(id,name,age,sex) values(student_id_seq.nextval,?,?,?)";
	private static final String queryStudentByIdSQL = "select name ,age ,sex from student where id = ?";

	@Override
	public void addStudent(final Student student) {
		// 这里采用和addTeacher不同的方式，输出插入数据库的主键ID
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(addStudentSQL,
						new String[] { "id" });
				ps.setString(1, student.getName());
				ps.setInt(2, student.getAge());
				ps.setString(3, student.getSex());
				return ps;
			}
		};

		jdbcTemplate.update(preparedStatementCreator, keyHolder);
		System.out.println("获取到的插入数据库的ID：" + keyHolder.getKey().longValue());
	}

	@Override
	public Student getStudent(int studentId) {
		logger.info("StudentId:" + studentId);

		final Student student = new Student();
		jdbcTemplate.query(queryStudentByIdSQL, new Object[] { studentId },
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						student.setAge(rs.getInt("age"));
						student.setName(rs.getString("name"));
						student.setSex(rs.getString("sex"));
					}
				});
		return student;
	}

	@Override
	public void updateStudent(Student student) {

	}

}
