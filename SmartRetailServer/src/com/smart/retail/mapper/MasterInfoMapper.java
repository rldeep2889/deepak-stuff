package com.smart.retail.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smart.retail.vo.MasterItemDetails;

public class MasterInfoMapper implements RowMapper<MasterItemDetails> {

	@Override
	public MasterItemDetails mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		MasterItemDetails masterItemDetails = new MasterItemDetails();

		masterItemDetails.setItemDescription(rs.getString("ITEM_DESCRIPTION"));
		masterItemDetails.setItemId(rs.getInt("ITEM_ID"));
		masterItemDetails.setItemImageUrl(rs.getString("ITEM_IMAGE_URL"));
		masterItemDetails.setItemName(rs.getString("ITEM_NAME"));
		masterItemDetails.setItemPrice(rs.getDouble("ITEM_PRICE"));

		return masterItemDetails;
	}

}
