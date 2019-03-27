package com.yunus.webproject.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yunus.webproject.entity.User;

@Entity
@Table(name = "project_information")
public class ProjectInformation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "description")
	private String description;

	@Column(name = "details")
	private String details;

	@Column(name = "project_status")
	@Enumerated(EnumType.STRING)
	private ProjectStatus projectStatus;

	@JoinColumn(name = "assignee_user_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private User assignee;

	@JoinColumn(name = "project_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Project project;

	public ProjectInformation() {

	}

	public ProjectInformation(Date createdAt, String description, String details, ProjectStatus projectStatus,
			User assignee, Project project) {
		this.createdAt = createdAt;
		this.description = description;
		this.details = details;
		this.projectStatus = projectStatus;
		this.assignee = assignee;
		this.project = project;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
