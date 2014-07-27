/**
 * 
 */
package com.sunray.exception;

/**
 * @author Sunray
 *
 */
public class SunrayException extends Exception {
	private static final long serialVersionUID = 7399418316891475577L;
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public SunrayException(String errorCode, String errorMessage){
		super(errorCode);
		this.errorMessage = errorMessage;
	}
}
