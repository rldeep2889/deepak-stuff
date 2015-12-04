package com.smart.retail.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smart.retail.vo.SmartUserData;

public class UserDataMapper implements RowMapper<SmartUserData>{
	
	@Override
	public SmartUserData mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		SmartUserData userData = new SmartUserData();

		userData.setDeviceId(rs.getString("DEVICE_ID"));
		userData.setEmailId(rs.getString("EMAIL_ID"));
		userData.setFirstName(rs.getString("FIRST_NAME"));
		userData.setMobNo(rs.getString("MOB_NO"));
		userData.setPassword(rs.getString("PASSWORD"));
		userData.setUserId(rs.getString("USER_ID"));
		userData.setUserName(rs.getString("USERNAME"));

		return userData;
	}
}
