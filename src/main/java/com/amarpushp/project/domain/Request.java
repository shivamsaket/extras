package com.amarpushp.project.domain;

import java.util.Map;

public class Request {

	private String resource; //"Resource path"
    private String path; //"Path parameter"
    private String httpMethod; //"Incoming request's method name"
    private Map<String, Object> headers; //{Incoming request headers}
    private Map<String, Object> queryStringParameters; //{query string parameters }
    private Map<String, Object> pathParameters; //{path parameters}
    //"stageVariables": {Applicable stage variables}
    private Map<String, Object> requestContext; //{Request context, including authorizer-returned key-value pairs}
    private String body; //"A JSON string of the request payload."
    private boolean isBase64Encoded; //"A boolean flag to indicate if the applicable request payload is Base64-encode"
    
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public Map<String, Object> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, Object> headers) {
		this.headers = headers;
	}
	public Map<String, Object> getQueryStringParameters() {
		return queryStringParameters;
	}
	public void setQueryStringParameters(Map<String, Object> queryStringParameters) {
		this.queryStringParameters = queryStringParameters;
	}
	public Map<String, Object> getPathParameters() {
		return pathParameters;
	}
	public void setPathParameters(Map<String, Object> pathParameters) {
		this.pathParameters = pathParameters;
	}
	public Map<String, Object> getRequestContext() {
		return requestContext;
	}
	public void setRequestContext(Map<String, Object> requestContext) {
		this.requestContext = requestContext;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public boolean isBase64Encoded() {
		return isBase64Encoded;
	}
	public void setBase64Encoded(boolean isBase64Encoded) {
		this.isBase64Encoded = isBase64Encoded;
	}

}
