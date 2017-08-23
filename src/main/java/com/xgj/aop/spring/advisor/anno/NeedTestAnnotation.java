package com.xgj.aop.spring.advisor.anno;

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
 * @Description: 自定义注解
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年8月23日 下午4:50:11
 */

// 声明注解的保留期限
@Retention(RetentionPolicy.RUNTIME)
// 声明可以使用该注解的目标类型
@Target(ElementType.METHOD)
// 可以被javadoc此类的工具文档化
@Documented
public @interface NeedTestAnnotation { // 定义注解
	// 声明注解成员
	boolean value() default false;
}
