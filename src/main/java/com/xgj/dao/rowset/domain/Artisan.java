package com.xgj.dao.rowset.domain;

import java.io.Serializable;

public class Artisan implements Serializable {

	private static final long serialVersionUID = 1L;

	private String artisanId;
	private String artisanName;

	public String getArtisanId() {
		return artisanId;
	}

	public void setArtisanId(String artisanId) {
		this.artisanId = artisanId;
	}

	public String getArtisanName() {
		return artisanName;
	}

	public void setArtisanName(String artisanName) {
		this.artisanName = artisanName;
	}

}
