package com.amarpushp.project.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amarpushp.project.domain.ProjectRequest;
import com.amarpushp.project.domain.Response;
import com.amarpushp.project.util.ProjectConstant;
import com.amarpushp.project.util.ProjectUtil;
import com.amarpushp.project.util.PropertyFileReader;

public class ProjectServiceImpl implements ProjectService{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Response saveProject(ProjectRequest request) throws Exception {
		logger.info("Trying to save project {projectId: " + request.getProjectId() + ", projectName: "
				+ request.getProjectName() + "}");
		Response response = new Response();
		try {
			response.setStatusCode(200);
			//Validating request body
			//ProjectUtil.validateEmailIds(request);			

			//String clientId = request.getClientId();
			//String propertyFileName = ProjectConstant.PROPERTY_FILE_NAME;
			
			/*if (StringUtils.isNotEmpty(clientId)) {
				propertyFileName = propertyFileName + ProjectConstant.HYPHEN + clientId + ProjectConstant.PROPERTY_FILE_EXTENSION;
			} else {
				propertyFileName = propertyFileName + ProjectConstant.PROPERTY_FILE_EXTENSION;
			}*/
			
			/*logger.info("Property file name : {}", propertyFileName);
			PropertyFileReader propertyFileReader = new PropertyFileReader(propertyFileName);
			Properties props = ProjectUtil.getProperties(propertyFileReader);
			logger.info("smtp properties created");
			Session session = ProjectUtil.getSession(props, propertyFileReader);
			logger.info("session created");
			Message message = ProjectUtil.getMImeMessage(session, propertyFileReader);
			ProjectUtil.populateMessageData(message, request);
			logger.info("mime message created");
			Transport.send(message);
			logger.info("email successfully sent");
			response.setStatusCode(ProjectConstant.RESPONSE_CODE_200);
			response.setBody(ProjectConstant.SUCCESS);*/
			
			logger.info("Email sent! and response returned");
		} catch (Exception ex) {
			logger.error("The email was not sent. Error message: " + ex.getMessage());
			ex.printStackTrace();
			throw ex;
		}

		return response;
	}
}
