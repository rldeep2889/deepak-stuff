package com.smart.retail.mapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.smart.retail.vo.CatalogInfo;

public class CatalogInfoMapper implements RowMapper<CatalogInfo> {

	public CatalogInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		CatalogInfo catalogInfo = new CatalogInfo();

		catalogInfo.setCatalogId(rs.getInt("catalogId"));
		catalogInfo.setCatalogDesc(rs.getString("catalogDesc"));

		Blob blob = rs.getBlob("videoByteArray");

		catalogInfo.setVideoByteArray(blob.getBytes(1, (int) blob.length()));
		return catalogInfo;
	}
}
