package com.xgj.aop.spring.advisor.aspectJ.function.thisFun;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.Ordered;

/**
 * 
 * 
 * @ClassName: AddTransportForBussinessAspect
 * 
 * @Description: 为Bussiness添加 ITransportService接口的切面
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月5日 下午9:18:50
 */

@Aspect
public class AddTransportForBussinessAspect implements Ordered {
	// (1)value 为BussinessService添加接口实现, (2)defaultImpl要添加的接口的默认的接口实现类
	@DeclareParents(value = "com.xgj.aop.spring.advisor.aspectJ.function.thisFun.BussinessService", defaultImpl = TransportService.class)
	public ITransportService iTransportService; // (3) 要实现的目标接口

	@Override
	public int getOrder() {
		return 2;
	}

}
