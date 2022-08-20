package com.hopital.urgence.exceptions;

public class ResourceNotInsertedException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotInsertedException(String message) {
		super(message);
	}
}
