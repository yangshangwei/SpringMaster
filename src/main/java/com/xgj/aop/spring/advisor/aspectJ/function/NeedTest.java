package com.xgj.aop.spring.advisor.aspectJ.function;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * @ClassName: NeedTest
 * 
 * @Description: 自定义注解@NeedTest
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月26日 下午11:19:12
 */

// 声明注解的保留期限
@Retention(RetentionPolicy.RUNTIME)
// 声明可以使用该注解的目标类型
@Target(ElementType.METHOD)
@Documented
public @interface NeedTest {
	// 声明注解成员
	boolean value() default false;
}
