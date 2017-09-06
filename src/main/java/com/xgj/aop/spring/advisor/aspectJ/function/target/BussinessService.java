package com.xgj.aop.spring.advisor.aspectJ.function.target;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: BussinessService
 * 
 * @Description: @Component标注的bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月5日 下午8:18:03
 */

@Component
public class BussinessService {

	public String doSomething() {
		System.out.println("doSomething executed");
		return "success";
	}
}
