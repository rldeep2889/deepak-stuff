package com.smart.retail.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smart.retail.vo.UserItemDetails;

public class UserItemsMapper implements RowMapper<UserItemDetails>{
	
	public UserItemDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserItemDetails userItems = new UserItemDetails();
		
		userItems.setUserId(rs.getString("USER_ID"));
		userItems.setUserItems(rs.getString("USER_ITEMS"));
		return userItems;
	}

}
