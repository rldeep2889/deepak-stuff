package com.test;

import com.json.converter.JSONConverter;
import com.smart.retail.vo.SmartUserData;
import com.smart.retail.vo.UserItemDetails;

public class TestClass {

	public static void main(String[] args) {

		SmartUserData data = new SmartUserData();
		data.setDeviceId("98745613");
		data.setEmailId("temp1@bosch.com");
		data.setFirstName("Temp1");
		data.setMobNo("9999999999");
		data.setPassword("secrettemp");
		data.setUserName("tempuser");

		String json = null;

		// json = createSmartUserData();

		json = createUserItemDetails();

		System.out.println("JSON :: " + json);

	}

	private static String createSmartUserData() {
		SmartUserData data = new SmartUserData();
		data.setDeviceId("98745613");
		data.setEmailId("temp1@bosch.com");
		data.setFirstName("Temp1");
		data.setMobNo("9999999999");
		data.setPassword("secrettemp");
		data.setUserName("tempuser");
		String json = JSONConverter.convertToJson(data);

		return json;
	}

	private static String createUserItemDetails() {
		UserItemDetails data = new UserItemDetails();

		data.setUserId("syuguagshdhasdh");
		data.setUserItems("1000,10001");

		String json = JSONConverter.convertToJson(data);

		return json;
	}

}
