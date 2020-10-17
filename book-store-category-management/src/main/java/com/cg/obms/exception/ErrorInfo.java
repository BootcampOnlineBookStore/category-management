package com.cg.obms.exception;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;

/************************************************************************************
 *			@author         	TARUN KUMAR BANDARU
 *          
 *          Description     	It is a error information class that is used to 
 *          					display error messages that are raised by exceptions
 *          					in a formatted manner.
 *                                                 
 *         	Version          	1.0
 *         
 *         	Created Date    	07-OCT-2020
 ************************************************************************************/
@ControllerAdvice
public class ErrorInfo {
	private LocalDateTime timestamp;
	private String errorMessage;
	private String details;
	
	public ErrorInfo(LocalDateTime timestamp, String errorMessage, String details) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.details = details;
	}
	public ErrorInfo() {
		super();
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}
