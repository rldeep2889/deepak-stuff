package com.smart.retail.vo;

public class SmartException extends Exception{
	
	private String errorMesg = null;
	private String typeOfError = null;
	public String getErrorMesg() {
		return errorMesg;
	}
	public void setErrorMesg(String errorMesg) {
		this.errorMesg = errorMesg;
	}
	public String getTypeOfError() {
		return typeOfError;
	}
	public void setTypeOfError(String typeOfError) {
		this.typeOfError = typeOfError;
	}
	
	

}
