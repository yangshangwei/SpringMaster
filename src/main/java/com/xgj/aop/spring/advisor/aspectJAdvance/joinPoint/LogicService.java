package com.xgj.aop.spring.advisor.aspectJAdvance.joinPoint;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: LogicService
 * 
 * @Description: @Component标注的Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月12日 上午1:09:38
 */

@Component
public class LogicService {

	public void dealLogic(String bussiness) {
		System.out.println("deal Logic：" + bussiness);
	}
}
