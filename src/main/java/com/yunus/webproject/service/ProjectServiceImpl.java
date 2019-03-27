package com.yunus.webproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yunus.webproject.dao.ProjectsDao;
import com.yunus.webproject.entity.Project;
import com.yunus.webproject.entity.ProjectInformation;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectsDao projectDao;

	@Override
	@Transactional
	public List<Project> getProjects() {
		return projectDao.getProjects();
	}

	@Override
	@Transactional
	public List<ProjectInformation> getProjectDetails() {
		return projectDao.getProjectDetails();
	}

	@Override
	@Transactional
	public void saveDetails(ProjectInformation projectInformation) {
		projectDao.saveDetails(projectInformation);
	}

	@Override
	@Transactional
	public void saveProject(Project project) {
		projectDao.saveProject(project);
	}
}
