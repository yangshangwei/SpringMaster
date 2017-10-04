package com.xgj.cache.springCacheAnno.CompleteDemoWithEhCache.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xgj.cache.springCacheAnno.CompleteDemoWithEhCache.domain.Product;

/**
 * 
 * 
 * @ClassName: ProductServiceImpl
 * 
 * @Description:@Service标注的服务层
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年10月3日 下午5:22:30
 */

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);

	private static List<Product> products;

	static {
		products = getDummyProducts();
	}

	@Cacheable(cacheNames = "products", key = "#name", condition = "#name != 'HTC'", unless = "#result==null")
	@Override
	public Product getByName(String name) {
		logger.info("<!----------Entering getByName()--------------------->");
		for (Product product : products) {
			if (product.getName().equalsIgnoreCase(name)) {
				return product;
			}
		}
		return null;
	}

	@CachePut(cacheNames = "products", key = "#product.name", unless = "#result==null")
	@Override
	public Product updateProduct(Product product) {
		logger.info("<!----------Entering updateProduct()--------------------->");
		for (Product p : products) {
			if (p.getName().equalsIgnoreCase(product.getName())) {
				p.setPrice(product.getPrice());
				return p;
			}
		}
		return null;
	}

	@CacheEvict(cacheNames = "products", allEntries = true)
	@Override
	public void refreshAllProducts() {

	}

	private static List<Product> getDummyProducts() {
		products = new ArrayList<Product>();
		products.add(new Product("IPhone", 500));
		products.add(new Product("Samsung", 600));
		products.add(new Product("HTC", 800));
		return products;
	}


}
