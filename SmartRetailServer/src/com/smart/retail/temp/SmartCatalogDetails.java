package com.smart.retail.temp;

public class SmartCatalogDetails {

	private int categoryId = 0;
	private String categoryName = null;
	private int catalogId = 0;
	private String catalogName = null;
	private String catalogImageUrl = null;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getCatalogImageUrl() {
		return catalogImageUrl;
	}

	public void setCatalogImageUrl(String catalogImageUrl) {
		this.catalogImageUrl = catalogImageUrl;
	}

}
