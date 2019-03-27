package com.yunus.webproject.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yunus.webproject.entity.Project;
import com.yunus.webproject.entity.ProjectInformation;

@Repository
public class ProjectsDaoImpl implements ProjectsDao {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public List<Project> getProjects() {
		
		Session session=factory.getCurrentSession();
		Query<Project> theQuery=session.createQuery("from Project order by projectName",Project.class);
		List<Project> projects=theQuery.getResultList();
		return projects;
	}

	@Override
	public List<ProjectInformation> getProjectDetails() {
		
		Session session=factory.getCurrentSession();
		Query<ProjectInformation> theQuery=session.createQuery("from ProjectInformation order by id",ProjectInformation.class);
		List<ProjectInformation> projectInformations=theQuery.getResultList();
		return projectInformations;
	}

	@Override
	public void saveDetails(ProjectInformation projectInformation) {
		
		Session session=factory.getCurrentSession();
		projectInformation.setCreatedAt(new Date());
		session.save(projectInformation);
		
	}

	@Override
	public void saveProject(Project project) {
		
		Session session=factory.getCurrentSession();
		project.setCreatedAt(new Date());
		session.save(project);
		
	}
}
