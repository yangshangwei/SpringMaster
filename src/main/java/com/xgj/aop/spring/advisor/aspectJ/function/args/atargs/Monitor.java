package com.xgj.aop.spring.advisor.aspectJ.function.args.atargs;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * @ClassName: Monitor
 * 
 * @Description: 自定义注解 @Monitor
 *               更多信息请阅读http://blog.csdn.net/yangshangwei/article/
 *               details/77477840
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月1日 下午4:00:12
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
public @interface Monitor {

	public boolean value() default true;
}
