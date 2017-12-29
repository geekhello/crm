package com.crm.exception;

public class BusinessException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 528234822986072418L;
	// 错误信息
	private String message;
	
	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
