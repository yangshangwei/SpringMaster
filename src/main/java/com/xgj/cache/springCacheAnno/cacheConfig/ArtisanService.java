package com.xgj.cache.springCacheAnno.cacheConfig;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "artisans")
public class ArtisanService {

	@Cacheable
	public Artisan getArtisanA(String artisanName) {
		Artisan artisan = new Artisan();
		return artisan;
	}

	@Cacheable(cacheNames = "artisanB")
	public Artisan getArtisanB(String artisanName) {
		Artisan artisan = new Artisan();
		return artisan;
	}
}
