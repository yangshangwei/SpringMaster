package com.xgj.aop.spring.advisor.aspectJAdvance.bindProxyObj;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @ClassName: BussinessLogicService
 * 
 * @Description: @Component标注的bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月12日 下午12:11:28
 */

@Component
public class BussinessLogicService {

	public void doLogic() {
		System.out.println("BussinessLogicService doLogic executed ");
	}
}
