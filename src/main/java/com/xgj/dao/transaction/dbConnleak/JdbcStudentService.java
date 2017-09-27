package com.xgj.dao.transaction.dbConnleak;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;

@Service
public class JdbcStudentService {
	private Logger logger = Logger.getLogger(JdbcStudentService.class);

	private static final String addStudentSQL = "insert into student(id,name,age,sex) values(student_id_seq.nextval,?,?,?)";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addStudent(Student student) {
		Connection conn = null;
		try {
			// (0)直接从数据源获取连接，后续程序没有显式释放该连接
			// Connection connection = jdbcTemplate.getDataSource()
			// .getConnection();

			// 在事务环境下，通过DataSourceUtils获取数据连接
			conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());

			jdbcTemplate.update(addStudentSQL, student.getName(),
					student.getAge(), student.getSex());
			Thread.sleep(1000);// (0-1)模拟程序代码的执行时间
			logger.info("addStudent successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 显式使用DataSourceUtils释放连接
			DataSourceUtils.releaseConnection(conn,
					jdbcTemplate.getDataSource());
		}

	}

	// (1)以异步线程的方式执行JdbcStudentService#addStudent()方法，以模拟多线程的环境
	public static void asynchrLogon(JdbcStudentService userService,
			Student student) {
		StudentServiceRunner runner = new StudentServiceRunner(userService,
				student);
		runner.start();
	}

	private static class StudentServiceRunner extends Thread {
		private JdbcStudentService studentService;
		private Student student;

		public StudentServiceRunner(JdbcStudentService studentService,
				Student student) {
			this.studentService = studentService;
			this.student = student;
		}

		public void run() {
			studentService.addStudent(student);
		}
	}

	// (2) 让主执行线程睡眠一段指定的时间
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * @Title: reportConn
	 * 
	 * @Description: (3)汇报数据源的连接占用情况
	 * 
	 * @param basicDataSource
	 * 
	 * @return: void
	 */
	public static void reportConn(BasicDataSource basicDataSource) {
		System.out.println("连接数[active:idle]-["
				+ basicDataSource.getNumActive() + ":"
				+ basicDataSource.getNumIdle() + "]");
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/xgj/dao/transaction/dbConnleak/conf_conn_leak.xml");
		JdbcStudentService jdbcStudentService = (JdbcStudentService) ctx
				.getBean("jdbcStudentService");

		BasicDataSource basicDataSource = (BasicDataSource) ctx
				.getBean("dataSource");

		// (4)汇报数据源初始连接占用情况
		JdbcStudentService.reportConn(basicDataSource);

		Student student = new Student();
		student.setAge(20);
		student.setName("LEAK");
		student.setSex("MALE");

		JdbcStudentService.asynchrLogon(jdbcStudentService, student);
		JdbcStudentService.sleep(500);

		// (5)此时线程A正在执行JdbcStudentService#addStudent()方法
		JdbcStudentService.reportConn(basicDataSource);

		JdbcStudentService.sleep(2000);
		// (6)此时线程A所执行的JdbcStudentService#addStudent()方法已经执行完毕
		JdbcStudentService.reportConn(basicDataSource);

		JdbcStudentService.asynchrLogon(jdbcStudentService, student);
		JdbcStudentService.sleep(500);

		// (7)此时线程B正在执行JdbcStudentService#addStudent()方法
		JdbcStudentService.reportConn(basicDataSource);

		JdbcStudentService.sleep(2000);

		// (8)此时线程A和B都已完成JdbcStudentService#addStudent()方法的执行
		JdbcStudentService.reportConn(basicDataSource);
	}
}
