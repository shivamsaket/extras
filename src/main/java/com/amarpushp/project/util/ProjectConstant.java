package com.amarpushp.project.util;

public class ProjectConstant {

	public static String SUCCESS = "SUCCESS";
	public static String FAIL = "FAIL";
	
	public static int RESPONSE_CODE_200 = 200;
	public static int RESPONSE_CODE_400 = 400;
	public static int RESPONSE_CODE_500 = 500;
	
	public static final String HTTPMETHOD = "httpMethod";
	public static final String EMAIL_FOLDER = "emailtemplates";
	public static final String TEMPLATE_DEFAULT_EMAIL = "DefaultEmail.vm";
	public static final String TEMPLATE_WELCOME_EMAIL = "WelcomeEmail.vm";
	public static final String EMAIL_CONTENT_TYPE = "text/html; charset=utf-8";
	public static final String PROPERTY_FILE_NAME = "application";
	public static final String PROPERTY_FILE_EXTENSION = ".properties";
	public static final String HYPHEN = "-";
	
	// Regex
	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
}
