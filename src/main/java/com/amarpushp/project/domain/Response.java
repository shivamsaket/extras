package com.amarpushp.project.domain;

import java.util.List;
import java.util.Map;

public class Response {

	private int statusCode;
	private String body;
	private Map<String, String> headers;
	private boolean isBase64Encoded;
	private List<String> errors;

	public Response() {
		this.statusCode = 200;
		this.body = null;
		this.headers = null;
		this.isBase64Encoded  = false;
	}
	
	public Response(int satusCode) {
		this.statusCode = satusCode;
		this.body = null;
		this.headers = null;
		this.isBase64Encoded  = false;
	}
	
	public Response(int satusCode, String body, Map<String, String> headers, boolean isBase64Encoded, List<String> errors) {
		this.statusCode = satusCode;
		this.body = body;
		this.headers = headers;
		this.isBase64Encoded  = isBase64Encoded;
		this.errors = errors;
	}


	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public boolean isBase64Encoded() {
		return isBase64Encoded;
	}

	public void setBase64Encoded(boolean isBase64Encoded) {
		this.isBase64Encoded = isBase64Encoded;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
