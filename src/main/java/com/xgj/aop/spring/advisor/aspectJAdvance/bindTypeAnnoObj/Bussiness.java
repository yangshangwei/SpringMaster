package com.xgj.aop.spring.advisor.aspectJAdvance.bindTypeAnnoObj;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: Bussiness
 * 
 * @Description: bean使用@Component注解，
 * 
 *               同时标注了@@Monitor注解，所有Bussiness Bean匹配切点， 其@Monitor注解对象将绑定到增强方法中
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月12日 下午4:32:23
 */

@Component
@Monitor
public class Bussiness {

	public void dealBussinessOne() {
		System.out.println("dealBussinessOne executed");
	}

	public void dealBussinessTwo() {
		System.out.println("dealBussinessTwo executed");
	}
}
