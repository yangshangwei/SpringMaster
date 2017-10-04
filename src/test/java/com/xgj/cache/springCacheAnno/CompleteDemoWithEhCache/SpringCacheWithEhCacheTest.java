package com.xgj.cache.springCacheAnno.CompleteDemoWithEhCache;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.xgj.cache.springCacheAnno.CompleteDemoWithEhCache.configuration.AppConfig;
import com.xgj.cache.springCacheAnno.CompleteDemoWithEhCache.domain.Product;
import com.xgj.cache.springCacheAnno.CompleteDemoWithEhCache.service.ProductService;

public class SpringCacheWithEhCacheTest {

	private static final Logger logger = Logger
			.getLogger(SpringCacheWithEhCacheTest.class);

	AbstractApplicationContext context = null;

	@Before
	public void initContext() {
		context = new AnnotationConfigApplicationContext(AppConfig.class);

	}

	@Test
	public void test() {
		ProductService service = (ProductService) context
				.getBean("productService");

		logger.info("IPhone ->" + service.getByName("IPhone"));
		logger.info("IPhone ->" + service.getByName("IPhone"));
		logger.info("IPhone ->" + service.getByName("IPhone"));

		logger.info("HTC ->" + service.getByName("HTC"));
		logger.info("HTC ->" + service.getByName("HTC"));
		logger.info("HTC ->" + service.getByName("HTC"));

		Product product = new Product("IPhone", 550);
		service.updateProduct(product);

		logger.info("IPhone ->" + service.getByName("IPhone"));
		logger.info("IPhone ->" + service.getByName("IPhone"));
		logger.info("IPhone ->" + service.getByName("IPhone"));

		logger.info("Refreshing all products");

		service.refreshAllProducts();
		logger.info("IPhone [after refresh]->" + service.getByName("IPhone"));
		logger.info("IPhone [after refresh]->" + service.getByName("IPhone"));
		logger.info("IPhone [after refresh]->" + service.getByName("IPhone"));
	}

	@After
	public void releaseContext() {
		((AbstractApplicationContext) context).close();
	}

}