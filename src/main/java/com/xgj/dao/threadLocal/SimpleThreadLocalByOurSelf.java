package com.xgj.dao.threadLocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * @ClassName: SimpleThreadLocaByOurSelf
 * 
 * @Description: ThreadLocal的伪代码,简易实现
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月19日 下午4:58:23
 */

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SimpleThreadLocalByOurSelf {

	private Map valueMap = Collections.synchronizedMap(new HashMap());

	/**
	 * 
	 * 
	 * @Title: set
	 * 
	 * @Description: 键为线程对象,值为本线程的变量副本
	 * 
	 * @param newValue
	 * 
	 * @return: void
	 */
	public void set(Object newValue) {
		valueMap.put(Thread.currentThread(), newValue);
	}

	/**
	 * 
	 * 
	 * @Title: get
	 * 
	 * @Description: 如果Map中没有key ,则设置为初始值null ,否则从map中获取
	 * 
	 * 
	 * @return: void
	 */
	public void get() {
		Thread currentThread = Thread.currentThread();
		Object object = valueMap.get("currentThread");
		if (object == null && !valueMap.containsKey(currentThread)) {
			object = initValue();
		} else {
			object = valueMap.get(currentThread);
		}
	}

	/**
	 * 
	 * 
	 * @Title: remove
	 * 
	 * @Description: 移除
	 * 
	 * 
	 * @return: void
	 */
	public void remove() {
		Thread currentThread = Thread.currentThread();
		valueMap.remove(currentThread);
	}

	private Object initValue() {
		return null;
	}
}
