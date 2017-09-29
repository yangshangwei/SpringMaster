package com.xgj.dao.lob.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.FileCopyUtils;

import com.xgj.dao.lob.domain.Artisan;

public class ArtisanDaoLobTest {

	ClassPathXmlApplicationContext ctx = null;
	ArtisanLobDaoImp artisanLobDaoImp = null;

	@Before
	public void initContext() {
		// 启动Spring 容器
		ctx = new ClassPathXmlApplicationContext(
				"classpath:com/xgj/dao/lob/lobOperation.xml");
		System.out.println("initContext successfully");

		artisanLobDaoImp = ctx.getBean("artisanLobDaoImp",
				ArtisanLobDaoImp.class);
	}

	public void testCallProcWithCallableStatementCreator() throws IOException {

		// 实例化Artisan
		Artisan artisan = new Artisan();
		// (maven工程资源放在了 resource同名目录下)

		// 设置主键
		artisan.setArtisanId(UUID.randomUUID().toString());

		// 读取文本文件，设置给artisanDetail
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource resource = resourcePatternResolver
				.getResource("classpath:com/xgj/dao/lob/dao/artisanDetail.txt");
		InputStream ins = resource.getInputStream();
		// 将 InputStream 转成String
		// Scanner scanner = new Scanner(ins, "GB2312");
		// String artisanDetail = scanner.useDelimiter("\\A").next();
		String artisanDetail = inputStream2String(ins).toString();
		// 设置给artisanDetail
		artisan.setArtisanDetail(artisanDetail);

		// 读取图片信息，设置给artisanAttach
		ClassPathResource res = new ClassPathResource(
				"com/xgj/dao/lob/dao/281015.jpg");
		// 读取图片数据
		byte[] artisanAttach = FileCopyUtils.copyToByteArray(res
				.getInputStream());
		artisan.setArtisanAttach(artisanAttach);

		artisanLobDaoImp.addArtisanLob(artisan);
		System.out.println("ADD  BLOB  SUCCESSFULLY ");

		System.out.println("artisan ID:\n" + artisan.getArtisanId());
		System.out.println("artisan detail:\n" + artisan.getArtisanDetail());
		System.out.println("artisan attach length:\n"
				+ artisan.getArtisanAttach().length);

	}

	public void getArtisanListById() {
		List<Artisan> artisans = artisanLobDaoImp
				.selectArtisanById("15e396c9-9151-4689-bc4f-e1a7ba5bd55c");

		for (Artisan artisan : artisans) {
			System.out
					.println("artisan detail:\n" + artisan.getArtisanDetail());

			System.out.println("artisan attach length:\n"
					+ artisan.getArtisanAttach().length);
		}
	}

	@Test
	public void getArtisanAttache() throws FileNotFoundException {
		// 定义输出目的
		OutputStream os = new FileOutputStream(new File("D:/downLoad.jpg"));
		artisanLobDaoImp.getAttach("15e396c9-9151-4689-bc4f-e1a7ba5bd55c", os);
	}

	@After
	public void closeContext() {
		if (ctx != null) {
			ctx.close();
		}
		System.out.println("close context successfully");
	}

	public StringBuilder inputStream2String(InputStream ins) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(ins));
		boolean firstLine = true;
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if (!firstLine) {
				stringBuilder.append(System.getProperty("line.separator"));
			} else {
				firstLine = false;
			}
			stringBuilder.append(line);
		}

		return stringBuilder;
	}
}
