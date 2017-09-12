package com.xgj.aop.spring.advisor.aspectJAdvance.bindTypeAnnoObj;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//声明注解的保留期限
@Retention(RetentionPolicy.RUNTIME)
// 声明可以使用该注解的目标类型
@Target(ElementType.TYPE)
// 可以被javadoc此类的工具文档化
@Documented
public @interface Monitor { // 定义注解
	// 声明注解成员
	boolean value() default false;
}
