package com.xgj.ioc.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 将一个POJO标注为定义Bean的配置类
@Configuration
public class Teacher {

	/**
	 * 
	 * 
	 * @Title: studentOne
	 * 
	 * @Description: 定义了一个Bean,并提供了Bean的实例化逻辑
	 * 
	 * @return
	 * 
	 * @return: StudentOne
	 */
	@Bean
	public StudentOne studentOne() {
		return new StudentOne();
	}

	/**
	 * 
	 * 
	 * @Title: studentTwo
	 * 
	 * @Description: 定义了一个Bean,并提供了Bean的实例化逻辑
	 * 
	 * @return
	 * 
	 * @return: StudentTwo
	 */
	@Bean
	public StudentTwo studentTwo() {
		return new StudentTwo();
	}

	public void arrangeStudent() {
		studentOne().doCleanWork();
		studentTwo().doHomeWork();
	}

}
