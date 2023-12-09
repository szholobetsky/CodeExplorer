package com.codexplorer.gitscan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long projectId;
	
	private String projectName;
	private ProjectStatus status;
	private String description;	
	private String gitURL;
	private String jiraURL;
	private String owner;
	private String repositoryName;
	@Column(nullable = false)
	private String versioningSystems;
	@Column(nullable = false)
	private String taskTrackingSystem;
	
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public ProjectStatus getStatus() {
		return status;
	}
	public void setStatus(ProjectStatus status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGitURL() {
		return gitURL;
	}
	public void setGitURL(String gitURL) {
		this.gitURL = gitURL;
	}
	public String getJiraURL() {
		return jiraURL;
	}
	public void setJiraURL(String jiraURL) {
		this.jiraURL = jiraURL;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getRepositoryName() {
		return repositoryName;
	}
	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}
	public String getVersioningSystems() {
		return versioningSystems;
	}
	public void setVersioningSystems(String versioningSystems) {
		this.versioningSystems = versioningSystems;
	}
	public String getTaskTrackingSystem() {
		return taskTrackingSystem;
	}
	public void setTaskTrackingSystem(String taskTrackingSystem) {
		this.taskTrackingSystem = taskTrackingSystem;
	}
	
}
