package com.xgj.dao.transaction.multiThreadinTrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgj.dao.transaction.multiThreadinTrans.domain.Student;

/**
 * 
 * 
 * @ClassName: MulitThreadService
 * 
 * @Description: 继承抽象基类MulitThreadBaseService
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月26日 下午4:44:18
 */

@Service
public class MulitThreadService extends MulitThreadBaseService {

	private AnotherService anotherService;

	private StudentService studentService;

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Autowired
	public void setAnotherService(AnotherService anotherService) {
		this.anotherService = anotherService;
	}

	/**
	 * 
	 * 
	 * @Title: executeLogic
	 * 
	 * @Description: (1)在executeLogic方法体中启动一个独立的线程，
	 *               在该独立的线程中执行AnotherService#doAnotherThing ()方法
	 * 
	 * 
	 * @return: void
	 */
	public void executeLogic() {
		System.out.println("logon method...");
		// 调用本类的其他方法
		method1();

		// 调用其他类的方法，在同一个线程中调用anotherService#doAnotherThing(),将运行在同一个事务中
		anotherService.doAnotherThing();

		// 在一个新的线程中调用anotherService#doAnotherThing(),将启动一个新的事务
		// 注意： 这里需要使用 extend Thread的方式 ，通过implements Runnable ，经验证不会开启新的事务
		new MyThread().start();
		// 必须休眠几秒，否则执行不到 新线程中的 方法
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// new MyThread1().run(); 这个会加到存在的事务中，原因暂时未知

	}

	public void method1() {
		System.out.println("method1 begins");
		System.out.println("模拟执行jdbc操作");
		System.out.println("method1 finish");
	}

	/**
	 * 
	 * 
	 * @ClassName: MyThread
	 * 
	 * @Description: 负责执行AnotherService#doAnotherThing()的线程
	 * 
	 * @author: Mr.Yang
	 * 
	 * @date: 2017年9月26日 下午4:50:29
	 */
	class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("before studentService.updateSutdent method..."
					+ anotherService.getClass().getName());

			// anotherService.doAnotherThing();
			Student student = new Student();
			student.setName("1XXX");
			student.setAge(112);
			student.setSex("1B");
			student.setStudentId(1);
			studentService.updateSutdent(student);
			System.out.println("after studentService.updateSutdent method...");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class MyThread1 implements Runnable {
		@Override
		public void run() {
			System.out.println("before studentService.updateSutdent method..."
					+ anotherService.getClass().getName());
			// anotherService.doAnotherThing();
			Student student = new Student();
			student.setName("XXX");
			student.setAge(12);
			student.setSex("B");
			student.setStudentId(1);
			studentService.updateSutdent(student);
			System.out.println("after studentService.updateSutdent method..."
					+ anotherService.getClass().getName());
		}
	}

}
