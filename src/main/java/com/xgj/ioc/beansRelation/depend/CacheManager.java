package com.xgj.ioc.beansRelation.depend;

import java.util.Timer;
import java.util.TimerTask;

public class CacheManager {

	public CacheManager() {
		Timer timer = new Timer();
		TimerTask cacheTask = new CacheTask();

		System.out.println("SystemSetting.REFRESH_CYCLE:"
				+ SystemSetting.REFRESH_CYCLE);

		timer.schedule(cacheTask, 0, SystemSetting.REFRESH_CYCLE);
	}

}
