package com.xgj.aop.spring.advisor.aspectJAdvance.pointOrder;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: Bussiness
 * 
 * @Description: @Component标注的Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月11日 上午1:38:06
 */

@Component
public class Bussiness {

	public void dealBussiness() {
		System.out.println("dealBussiness executed");
	}
}
