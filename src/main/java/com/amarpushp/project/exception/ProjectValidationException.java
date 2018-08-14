package com.amarpushp.project.exception;

public class ProjectValidationException extends Exception{

	private static final long serialVersionUID = -7308845001020729639L;

	public ProjectValidationException(String message) {
		super(message);
	}
	
	public ProjectValidationException(Throwable t) {
		super(t);
	}
	
	public ProjectValidationException(String message, Throwable t) {
		super(message, t);
	}
}
