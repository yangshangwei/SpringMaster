package com.xgj.aop.spring.advisor.aspectJ.function.within;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * @ClassName: Mart
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
public @interface Mart {

	public String value() default "";

}
