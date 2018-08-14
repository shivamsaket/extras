package com.amarpushp.project.domain;

import java.time.LocalDate;

public class ProjectRequest {
	
	private Integer projectId;
	private String projectName;
	private String projectDescription;
	private String expectedStartDate;
	private String expectedEndDate;
	private LocalDate actualStartDate;
	private LocalDate actualEndDate;
	private Integer customerId;
	private Integer statusId;
	private Integer approverId;
	private String assignedTo;
	private String comments;
	private LocalDate creationDate;
	private LocalDate createdBy;
	private LocalDate modifiedDate;
	private LocalDate modifiedBy;
	
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public String getExpectedStartDate() {
		return expectedStartDate;
	}
	public void setExpectedStartDate(String expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}
	public String getExpectedEndDate() {
		return expectedEndDate;
	}
	public void setExpectedEndDate(String expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}
	public LocalDate getActualStartDate() {
		return actualStartDate;
	}
	public void setActualStartDate(LocalDate actualStartDate) {
		this.actualStartDate = actualStartDate;
	}
	public LocalDate getActualEndDate() {
		return actualEndDate;
	}
	public void setActualEndDate(LocalDate actualEndDate) {
		this.actualEndDate = actualEndDate;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Integer getApproverId() {
		return approverId;
	}
	public void setApproverId(Integer approverId) {
		this.approverId = approverId;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDate getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(LocalDate createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDate getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public LocalDate getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(LocalDate modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	}
