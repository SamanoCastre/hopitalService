package com.hopital.urgence.exceptions;

public class NoMoreBedFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoMoreBedFoundException(String message) {
		super(message);
	}
}
