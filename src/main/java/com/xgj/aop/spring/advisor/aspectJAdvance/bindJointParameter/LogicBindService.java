package com.xgj.aop.spring.advisor.aspectJAdvance.bindJointParameter;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: LogicBindService
 * 
 * @Description: @Component标注的Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月12日 上午1:39:23
 */

@Component
public class LogicBindService {

	public void dealLogic(String bussiness, int number) {
		System.out.println("deal Logic：" + bussiness + ", number:" + number);
	}
}
