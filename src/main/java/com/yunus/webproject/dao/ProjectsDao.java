package com.yunus.webproject.dao;

import java.util.List;

import com.yunus.webproject.entity.Project;
import com.yunus.webproject.entity.ProjectInformation;

public interface ProjectsDao {
	
	public List<Project> getProjects();
	
	public List<ProjectInformation> getProjectDetails();
	
	public void saveDetails(ProjectInformation projectInformation);
	
	public void saveProject(Project project);

}
