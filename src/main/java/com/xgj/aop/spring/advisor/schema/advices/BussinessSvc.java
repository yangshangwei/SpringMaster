package com.xgj.aop.spring.advisor.schema.advices;

public class BussinessSvc {

	public void dealBussinessBefore() {
		System.out.println("dealBussinessBefore executed");
	}

	public int dealWorkNumberForAfterReturring() {
		System.out.println("dealWorkNumberForAfterReturring executed");
		return 10;
	}

	public void dealWorkForAround(String workName) {
		System.out.println("dealWorkForAround executed");
	}

	public void dealBussinessForAfterThorowing(String bussinessName) {
		System.out.println("dealBussinessForAfterThorowing executed");
		// just a demo code ,in fact it's not cautious
		if (bussinessName != null && "bug".equals(bussinessName))
			throw new IllegalArgumentException("iae Exception");
		else
			throw new RuntimeException("re Exception");
	}

	public void dealWorkForAfter() {
		System.out.println("dealWorkForAfter executed");
	}
}
