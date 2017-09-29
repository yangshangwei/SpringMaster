package com.xgj.dao.lob.dao;

import java.util.List;

import com.xgj.dao.lob.domain.Artisan;

public interface ArtisanLobDao {

	public void addArtisanLob(Artisan artisan);

	public List<Artisan> selectArtisanById(String artisanId);

}
