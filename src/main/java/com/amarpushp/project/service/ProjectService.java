package com.amarpushp.project.service;

import com.amarpushp.project.domain.ProjectRequest;
import com.amarpushp.project.domain.Response;

public interface ProjectService {

	Response saveProject(ProjectRequest request) throws Exception;
}
