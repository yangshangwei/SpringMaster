package com.xgj.aop.spring.advisor.aspectJ.function.thisFun;

public class TransportService implements ITransportService {

	@Override
	public void doTransport() {
		System.out.println("doTransport executed");
	}

}
