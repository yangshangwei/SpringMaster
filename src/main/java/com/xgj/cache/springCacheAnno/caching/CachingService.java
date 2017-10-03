package com.xgj.cache.springCacheAnno.caching;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class CachingService {

	@CacheEvict(cacheNames = { "products", "items" }, key = "#product.name")
	public void refreshProduct(Product product) {
		// This method will remove only this specific product from 'products' &
		// 'items' cache.
	}

	@Caching(evict = {
			@CacheEvict(cacheNames = "products", key = "#product.name"),
			@CacheEvict(cacheNames = "items", key = "#product.id") })
	public void refreshProduct2(Product product) {
		// This method will remove only this specific product from 'products' &
		// 'items' cache.
	}

}
