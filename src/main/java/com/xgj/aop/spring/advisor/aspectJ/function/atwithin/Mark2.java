package com.xgj.aop.spring.advisor.aspectJ.function.atwithin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * @ClassName: Mark
 * 
 * @Description: 自定义注解
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月5日 下午12:02:46
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Mark2 {

	public String value() default "";

}
