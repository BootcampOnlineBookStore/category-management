package com.cg.obms.exception;

import java.time.LocalDateTime;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<ErrorInfo> handleException(CategoryException categoryException ,HttpServletRequest request)
	{
		
		 String message = categoryException.getMessage();
		 String uri= request.getRequestURI();
		 
		 ErrorInfo  errorInfo = new ErrorInfo(LocalDateTime.now(),message,uri);
		 return new ResponseEntity<>(errorInfo,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo>  handleException(Exception exception,HttpServletRequest request)
	{
		
		 String message=exception.getMessage();
		 String uri= request.getRequestURI();
		 
		 ErrorInfo  errorInfo = new ErrorInfo(LocalDateTime.now(),message,uri);
		 
		 return new ResponseEntity<>(errorInfo,HttpStatus.NOT_FOUND);

	}
	
}
