package com.xgj.cache.springCacheAnno.CompleteDemoWithEhCache.service;

import com.xgj.cache.springCacheAnno.CompleteDemoWithEhCache.domain.Product;

public interface ProductService {

	Product getByName(String name);

	Product updateProduct(Product product);

	void refreshAllProducts();
}
