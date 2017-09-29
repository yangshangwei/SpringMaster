package com.xgj.dao.lob.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.LobRetrievalFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import com.xgj.dao.lob.domain.Artisan;

/**
 * 
 * 
 * @ClassName: ArtisanLobDaoImp
 * 
 * @Description: @Repository标注的DAO层
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月28日 下午8:15:23
 */

@Repository
public class ArtisanLobDaoImp implements ArtisanLobDao {
	// 定义jdbcTemplate属性
	private JdbcTemplate jdbcTemplate;
	// 定义LobHander属性
	private LobHandler lobHandler;

	private static final String addArtisanLobSql = "insert into artisan_lob(artisan_id ,artisan_detail ,artisan_attach) values (?,?,?)";
	private static final String selectArtisanByIdSql = "select artisan_detail , artisan_attach from artisan_lob where artisan_id = ?";
	private static final String selectAttachByIdSql = "select  artisan_attach from artisan_lob where artisan_id = ?";

	// 注入jdbcTemplate
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// 注入lobHandler
	@Autowired
	public void setLobHandler(LobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}

	@Override
	public void addArtisanLob(final Artisan artisan) {

		jdbcTemplate.execute(addArtisanLobSql,
				new AbstractLobCreatingPreparedStatementCallback(
						this.lobHandler) {

					@Override
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException,
							DataAccessException {
						// 设置ID
						ps.setString(1, artisan.getArtisanId());
						// 设置 CLOB 字段
						lobCreator.setClobAsString(ps, 2,
								artisan.getArtisanDetail());
						// 设置 BLOB 字段
						lobCreator.setBlobAsBytes(ps, 3,
								artisan.getArtisanAttach());
					}
				});

	}

	@Override
	public List<Artisan> selectArtisanById(String artisanId) {

		List<Artisan> artisanList = jdbcTemplate.query(selectArtisanByIdSql,
				new Object[] { artisanId }, new RowMapper<Artisan>() {

					@Override
					public Artisan mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						// 以二进制数组方式获取 BLOB 数据。
						byte[] attach = lobHandler.getBlobAsBytes(rs,
								"artisan_attach");
						String artisanDetaiul = lobHandler.getClobAsString(rs,
								"artisan_detail");
						Artisan artisan = new Artisan();
						artisan.setArtisanAttach(attach);
						artisan.setArtisanDetail(artisanDetaiul);
						return artisan;
					}
				});

		return artisanList;
	}

	/**
	 * 
	 * 
	 * @Title: getAttach
	 * 
	 * @Description: 以流数据方式读取 LOB 数据
	 * 
	 * 
	 * @return: void
	 */
	public void getAttach(final String artisanId, final OutputStream os) {

		jdbcTemplate.query(selectAttachByIdSql, new Object[] { artisanId },
				new AbstractLobStreamingResultSetExtractor<Artisan>() { // 匿名内部类
					// 处理未找到数据行的情况
					protected void handleNoRowFound()
							throws LobRetrievalFailureException {
						System.out.println("Not Found result!");
					}

					// 以流的方式处理 LOB 字段
					public void streamData(ResultSet rs) throws SQLException,
							IOException {
						InputStream is = lobHandler
								.getBlobAsBinaryStream(rs, 1);
						if (is != null) {
							FileCopyUtils.copy(is, os);
						}
					}
				});

	}

}

/**
 * 
 * 
 * JdbcTemplate 中execute和update的区别：
 * 
 * execute不接受参数，无返回值，适用于create和drop table。
 * 
 * update可以接受参数，返回值为此次操作影响的记录数，适合于insert, update, 和delete等操作。
 * 
 */
