package com.xgj.dao.lob.domain;

import java.io.Serializable;

/**
 * 
 * 
 * @ClassName: Artisan
 * 
 * @Description: 实现序列化接口的实体类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月28日 下午8:14:37
 */
public class Artisan implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 对应ARTISAN_LOB表的 clob字段 artisan_id
	 */
	private String artisanId;

	/**
	 * 对应ARTISAN_LOB表的 clob字段 artisan_detail
	 */
	private String artisanDetail;

	/**
	 * 对应ARTISAN_LOB表的 clob字段 artisan_attach
	 */
	private byte[] artisanAttach;

	public String getArtisanDetail() {
		return artisanDetail;
	}

	public void setArtisanDetail(String artisanDetail) {
		this.artisanDetail = artisanDetail;
	}

	public byte[] getArtisanAttach() {
		return artisanAttach;
	}

	public void setArtisanAttach(byte[] artisanAttach) {
		this.artisanAttach = artisanAttach;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getArtisanId() {
		return artisanId;
	}

	public void setArtisanId(String artisanId) {
		this.artisanId = artisanId;
	}
}
