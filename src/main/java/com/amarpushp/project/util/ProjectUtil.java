package com.amarpushp.project.util;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amarpushp.project.domain.ProjectRequest;
import com.amarpushp.project.domain.Request;
import com.amarpushp.project.exception.ProjectValidationException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProjectUtil {
	
	private  static Logger logger = LoggerFactory.getLogger(ProjectUtil.class);
	
	private ProjectUtil() {
		
	}
	
	public static Properties getProperties(PropertyFileReader propertyFileReader) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", propertyFileReader.getProperty("mail.smtp.auth"));
		props.put("mail.smtp.starttls.enable", propertyFileReader.getProperty("mail.smtp.starttls.enable"));
		props.put("mail.smtp.host", propertyFileReader.getProperty("mail.smtp.host"));
		props.put("mail.smtp.port", propertyFileReader.getProperty("mail.smtp.port"));
		props.put("mail.debug", propertyFileReader.getProperty("mail.debug"));
		return props;
	}
	
	public static Session getSession(Properties props, PropertyFileReader propertyFileReader) {
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(propertyFileReader.getProperty("smtp.username"),
						propertyFileReader.getProperty("smtp.password"));
			}
		});
		
		return session;
	}
	
	public static Message getMImeMessage(Session session, PropertyFileReader propertyFileReader) throws Exception{
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(propertyFileReader.getProperty("smtp.username")));
		return message;
	}
	
	/*public static String getTemplateName(ProjectRequest request) {
		String templateName = ProjectConstant.EMAIL_FOLDER + "/" + ProjectConstant.TEMPLATE_DEFAULT_EMAIL;
		if (request.getTemplateName() != null && !request.getTemplateName().isEmpty()) {
			templateName = request.getTemplateName();
		}
		return templateName;
	}
	
	public static void populateMessageData(Message message, ProjectRequest request)  throws Exception {
		if(request.getToEmailIds() != null && request.getToEmailIds().size() > 0) {
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(StringUtils.join(request.getToEmailIds(), ",")));
		}
		
		if(request.getCcEmailIds() != null && request.getCcEmailIds().size() > 0) {
			message.setRecipients(Message.RecipientType.CC,
				InternetAddress.parse(StringUtils.join(request.getCcEmailIds(), ",")));
		}
		
		message.setSubject(request.getSubject());
		try {
			message.setContent(ProjectUtil.getTemplatedEmailBody(getTemplateName(request), request.getEmailParamMap()),
				ProjectConstant.EMAIL_CONTENT_TYPE);
		}catch(Exception e) {
			message.setContent(ProjectUtil.getTemplatedEmailBody(ProjectConstant.TEMPLATE_DEFAULT_EMAIL, request.getEmailParamMap()),
					ProjectConstant.EMAIL_CONTENT_TYPE);
		}
	}*/
	
	/*public static void validateEmailIds(ProjectRequest request) throws ProjectValidationException{
		boolean toIdFlag = EmailValidationUtil.validate(ProjectConstant.EMAIL_PATTERN, request.getToEmailIds());
		boolean ccIdFlag = EmailValidationUtil.validate(ProjectConstant.EMAIL_PATTERN, request.getCcEmailIds());
		if (toIdFlag == true && ccIdFlag == true) {
			return;
		}
		throw new ProjectValidationException(ValidationMessageEnum.INVALID_EMAIL_ID.toString());
	}*/
	
	public static String getMethod(Map<String, Object> input){
		String method = "";
		if (input instanceof Map){
			Object data = input.get(ProjectConstant.HTTPMETHOD);
			if (data != null){
				method = data.toString();
			}
		}
		return method;
	}
	
	public static ProjectRequest populateProjectRequest(Request request) {
		if (request != null) {
			try {
				String body = request.getBody();
				logger.info("Email Body : " + body);
				ObjectMapper mapper = new ObjectMapper();
				return mapper.readValue(body.getBytes(), ProjectRequest.class);
			}catch(Exception e) {
				logger.error("Exception in processing body "+ e.getStackTrace());
			}
		}
		return null;
	}
	
	public static String getTemplatedEmailBody(String templateName, Map<String, String> emailParamMap) {
		try {
			VelocityEngine ve = new VelocityEngine();
	        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	        ve.init();
	        /*  next, get the Template  */
	        Template template = ve.getTemplate(templateName);
	        /*  create a context and add data */
	        VelocityContext context = new VelocityContext();
	        emailParamMap.forEach((k,v)->{
	        	context.put(k, v);
	        });
	        
	        StringWriter writer = new StringWriter();
	        template.merge(context, writer);
	        return writer.toString();
		}catch(Exception e) {
			logger.error("Exception in merging email template");
			e.printStackTrace();
			return null;
		}
	}
}
