package com.codexplorer.gitscan.model;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Commit {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long commitId;
	
    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    Project project;
    
    @OneToMany(mappedBy="commit")
    private Set<ChangedFile> changes;
    
    private String gitUrl;
    private String commitMessage;
    private String gitId;
    private String author;
    private String ticketMessage;
    
	public Long getCommitId() {
		return commitId;
	}
	public void setCommitId(Long commitId) {
		this.commitId = commitId;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Set<ChangedFile> getChanges() {
		return changes;
	}
	public void setChanges(Set<ChangedFile> changes) {
		this.changes = changes;
	}
	public String getGitUrl() {
		return gitUrl;
	}
	public void setGitUrl(String gitUrl) {
		this.gitUrl = gitUrl;
	}
	public String getCommitMessage() {
		return commitMessage;
	}
	public void setCommitMessage(String commitMessage) {
		this.commitMessage = commitMessage;
	}
	public String getGitId() {
		return gitId;
	}
	public void setGitId(String gitId) {
		this.gitId = gitId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTicketMessage() {
		return ticketMessage;
	}
	public void setTicketMessage(String ticketMessage) {
		this.ticketMessage = ticketMessage;
	}
  
}
