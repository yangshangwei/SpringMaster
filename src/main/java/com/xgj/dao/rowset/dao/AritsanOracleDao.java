package com.xgj.dao.rowset.dao;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface AritsanOracleDao {

	SqlRowSet selectArtisanById(int artisanId);

}
