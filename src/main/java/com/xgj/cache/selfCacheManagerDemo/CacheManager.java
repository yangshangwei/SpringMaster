package com.xgj.cache.selfCacheManagerDemo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * 
 * @ClassName: CacheManager
 * 
 * @Description: 泛型类-自定义缓存管理器的粗略实现
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年10月2日 下午1:10:13
 */

public class CacheManager<T> {

	/**
	 * ConcurrentHashMap - 线程安全的集合容器
	 */
	Map<Object, T> cacheMap = new ConcurrentHashMap<Object, T>();

	/**
	 * 
	 * 
	 * @Title: getValue
	 * 
	 * @Description: 根据Key获取缓存数据
	 * 
	 * @param key
	 * @return
	 * 
	 * @return: T
	 */
	public T getValue(Object key) {
		return cacheMap.get(key);
	}

	/**
	 * 
	 * 
	 * @Title: addOrUpdateCache
	 * 
	 * @Description: 添加或者更新缓存
	 * 
	 * @param key
	 * @param value
	 * 
	 * @return: void
	 */
	public void addOrUpdateCache(Object key, T value) {
		cacheMap.put(key, value);
	}

	/**
	 * 
	 * 
	 * @Title: evictCache
	 * 
	 * @Description: 根据key， 从缓存中清除特定的key记录
	 * 
	 * @param key
	 * 
	 * @return: void
	 */
	public void evictCache(Object key) {
		if (cacheMap.containsKey(key)) {
			cacheMap.remove(key);
		}
	}

	/**
	 * 
	 * 
	 * @Title: evictCache
	 * 
	 * @Description: 清空缓存中的数据
	 * 
	 * 
	 * @return: void
	 */
	public void evictCache() {
		cacheMap.clear();
	}
}
