package com.xgj.cache.initData2CacheByOriginalMap.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgj.cache.initData2CacheByOriginalMap.dao.ArtisanServiceDao;
import com.xgj.cache.initData2CacheByOriginalMap.domain.LittleArtisan;


/**
 * 
 * 
 * @ClassName: ArtisanService
 * 
 * @Description: 
 *               最原始的使用缓存的方式是通过一个全局map保存获取过的数据，下次获取数据时先从map中提取，如果有就直接返回，如果没有就从数据库中去读取
 *               ，然后放入map中，当然，在做更新操作时需要同步更新这个map中的数据。 这种方式虽然原始，但是在一些简单的场景下已经够用
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年10月5日 下午1:16:56
 */

@Service
public class ArtisanService {
	Logger logger = Logger.getLogger(ArtisanService.class);

	public static Map<String, LittleArtisan> artisanMap = new ConcurrentHashMap<>();

	private ArtisanServiceDao artisanServiceDao;

	@Autowired
	public void setArtisanServiceDao(ArtisanServiceDao artisanServiceDao) {
		this.artisanServiceDao = artisanServiceDao;
	}

	/**
	 * 
	 * 
	 * @Title: loadData
	 * 
	 * @Description: Spring 容器初始化时加载
	 * 
	 * 
	 * @return: void
	 */
	public void loadInitData() {
		logger.info("load data when program starts.");
		
		
		List<LittleArtisan> artisanList = getAllArtisan();

		for (LittleArtisan artisan : artisanList) {
			artisanMap.put(artisan.getArtisanName(), artisan);
			System.out.println("cached to artisanMap "
					+ artisan.getArtisanName());
		}
	}

	public List<LittleArtisan> getAllArtisan() {
		return artisanServiceDao.getAllArtisan();
	}
}
