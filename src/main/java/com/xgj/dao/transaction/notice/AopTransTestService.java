package com.xgj.dao.transaction.notice;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @ClassName: AopTransTestService
 * 
 * @Description: 在配置文件中开启proxy-target-class="true" 使用CGlib动态字节码技术织入AOP事务增强
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月26日 上午2:01:33
 */

@Service
public class AopTransTestService {

	/**
	 * 
	 * 
	 * @Title: method1
	 * 
	 * @Description: private方法因为修饰符访问权限的控制，无法被子类覆盖
	 * 
	 * 
	 * @return: void
	 */
	private void method1() {
		System.out.println("method1 executed");
	}

	/**
	 * 
	 * 
	 * @Title: method2
	 * 
	 * @Description: final方法无法被子类覆盖
	 * 
	 * 
	 * @return: void
	 */
	private final void method2() {
		System.out.println("method2 executed");
	}

	/**
	 * 
	 * 
	 * @Title: method3
	 * 
	 * @Description: static方法是类级别的方法，无法被子类覆盖
	 * 
	 * 
	 * @return: void
	 */
	private static void method3() {
		System.out.println("method3 executed");
	}

	/**
	 * 
	 * 
	 * @Title: method4
	 * 
	 * @Description: public方法可以被子类覆盖，因此可以被动态字节码增强
	 * 
	 * 
	 * @return: void
	 */
	public void method4() {
		System.out.println("method4 executed");
	}

	/**
	 * 
	 * 
	 * @Title: method5
	 * 
	 * @Description: final方法无法被子类覆盖
	 * 
	 * 
	 * @return: void
	 */
	public final void method5() {
		System.out.println("method5 executed");
	}

	/**
	 * 
	 * 
	 * @Title: method6
	 * 
	 * @Description: protected方法可以被子类覆盖，因此可以被动态字节码增强
	 * 
	 * 
	 * @return: void
	 */
	protected void method6() {
		System.out.println("method6 executed");
	}

	/**
	 * 
	 * 
	 * @Title: main
	 * 
	 * @Description: 测试
	 * 
	 * @param args
	 * 
	 * @return: void
	 */
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = null;
		AopTransTestService aopTransTestService = null;

		// 启动Spring 容器
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/transaction/notice/conf_tx_notice.xml");
		aopTransTestService = ctx.getBean("aopTransTestService",
				AopTransTestService.class);
		System.out.println("initContext successfully");

		System.out.println("before method1");
		aopTransTestService.method1();
		System.out.println("after1 method1");

		System.out.println("before method2");
		aopTransTestService.method2();
		System.out.println("after1 method2");

		System.out.println("before method3");
		aopTransTestService.method3();
		System.out.println("after1 method3");

		System.out.println("before method4");
		aopTransTestService.method4();
		System.out.println("after1 method4");

		System.out.println("before method5");
		aopTransTestService.method5();
		System.out.println("after1 method5");

		System.out.println("before method6");
		aopTransTestService.method6();
		System.out.println("after1 method6");

		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}
}
