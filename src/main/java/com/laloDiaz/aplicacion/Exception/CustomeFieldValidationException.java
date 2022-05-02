package com.laloDiaz.aplicacion.Exception;

public class CustomeFieldValidationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6209025579693201784L;
	
	private String fieldName;
	
	public CustomeFieldValidationException(String message,String fieldName) {
		super(message);
		this.fieldName = fieldName;
	}
	
	public String getFieldName() {
		return this.fieldName;
	}
}
