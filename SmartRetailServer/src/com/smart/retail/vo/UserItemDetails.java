package com.smart.retail.vo;

public class UserItemDetails {

	private String userId = null;

	// private int categoryId = 0;
	// private int catalogId = 0;

	/** Holds the comma separated value of items **/
	private String userItems = null;

	// private int quantity = 0;

	public String getUserItems() {
		return userItems;
	}

	public void setUserItems(String userItems) {
		this.userItems = userItems;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
