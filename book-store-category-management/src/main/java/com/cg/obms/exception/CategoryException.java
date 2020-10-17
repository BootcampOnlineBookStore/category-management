package com.cg.obms.exception;

/************************************************************************************
 *			@author         	TARUN KUMAR BANDARU
 *          
 *          Description     	It is a user defined exception class
 *                                                 
 *         	Version          	1.0
 *         
 *         	Created Date    	06-OCT-2020
 ************************************************************************************/
public class CategoryException extends Exception{
	
	public CategoryException(String message)
	{
		super(message);
	}
	public CategoryException()
	{
		super();
	}

}
