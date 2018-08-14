package com.amarpushp.project.exception;

public class ProjectException extends Exception{

	private static final long serialVersionUID = -4202834506848456186L;
	
	public ProjectException(String message) {
		super(message);
	}
	
	public ProjectException(Throwable t) {
		super(t);
	}
	
	public ProjectException(String message, Throwable t) {
		super(message, t);
	}

}
