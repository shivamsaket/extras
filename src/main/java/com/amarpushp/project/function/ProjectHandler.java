package com.amarpushp.project.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amarpushp.project.domain.ProjectRequest;
import com.amarpushp.project.domain.Request;
import com.amarpushp.project.domain.Response;
import com.amarpushp.project.exception.ProjectException;
import com.amarpushp.project.exception.ProjectValidationException;
import com.amarpushp.project.service.ProjectService;
import com.amarpushp.project.service.ProjectServiceImpl;
import com.amarpushp.project.util.ProjectConstant;
import com.amarpushp.project.util.ProjectUtil;
import com.amarpushp.project.util.ValidationMessageEnum;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ProjectHandler implements RequestHandler<Request, Response> {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private ProjectService projectService = new ProjectServiceImpl();

	@Override
	public Response handleRequest(Request request, Context context) {
		logger.info("Inside EmailHandler : {}", request);
		Response response = new Response();
		try {
			ProjectRequest projectRequest = ProjectUtil.populateProjectRequest(request);
			//ResourceBundle bundle = ResourceBundle.getBundle("i18n.message", 
				//	new Locale(StringUtils.isNotBlank(projectRequest.getLanguage()) ? projectRequest.getLanguage() : "en"));
			logger.info("Project body : {}", request.getBody());
			response = projectService.saveProject(projectRequest);
		} catch (Exception e) {
			logger.error("Exception {}", e);
			e.printStackTrace();
			List<String> errors = new ArrayList<>();
			if (e instanceof ProjectValidationException) {
				errors.add(e.getMessage());
				response.setStatusCode(ProjectConstant.RESPONSE_CODE_400);
				response.setErrors(errors);
			} else if (e instanceof ProjectException){
				errors.add(ValidationMessageEnum.INTERNAL_SERVER_ERROR.toString());
				response.setStatusCode(ProjectConstant.RESPONSE_CODE_500);
			} else {
				response.setStatusCode(ProjectConstant.RESPONSE_CODE_500);
			}
		}
		return response;
	}
}
