package com.smart.retail.vo;

public class CatalogInfo {

	private byte[] videoByteArray = null;
	private int catalogId = 0;
	private String catalogDesc = null;

	public byte[] getVideoByteArray() {
		return videoByteArray;
	}

	public void setVideoByteArray(byte[] videoByteArray) {
		this.videoByteArray = videoByteArray;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogDesc() {
		return catalogDesc;
	}

	public void setCatalogDesc(String catalogDesc) {
		this.catalogDesc = catalogDesc;
	}

}
