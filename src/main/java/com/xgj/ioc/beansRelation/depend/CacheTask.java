package com.xgj.ioc.beansRelation.depend;

import java.util.TimerTask;

public class CacheTask extends TimerTask {

	@Override
	public void run() {
		try {
			// bussiness logic
			System.out.println("bussiness run");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
