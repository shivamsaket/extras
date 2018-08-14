package com.amarpushp.project.util;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

public class EmailClientFactory {

	private EmailClientFactory() {
		
	}
	
	// Regions.US_EAST_1 
	// Provides client for Email Service
    public static AmazonSimpleEmailService getEmailService(String accessKey, String accessSecret, Regions reason) {
    	AWSCredentials awsCredential = new BasicAWSCredentials(accessKey, accessSecret);
        AmazonSimpleEmailService client = 
       		 AmazonSimpleEmailServiceClientBuilder
       		 .standard()
       		 .withCredentials(new AWSStaticCredentialsProvider(awsCredential))
               //Regions.US_EAST_1 
                .withRegion(reason).build();
        return client;
    }
    
}
