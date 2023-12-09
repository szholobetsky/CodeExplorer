package com.codexplorer.gitscan.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codexplorer.gitscan.connector.TaskTrackerConnectorFactory;
import com.codexplorer.gitscan.model.Commit;
import com.codexplorer.gitscan.model.Project;
import com.codexplorer.gitscan.model.ProjectStatus;
import com.codexplorer.gitscan.repository.CommitRepository;
import com.codexplorer.gitscan.repository.ProjectRepository;
import com.codexplorer.gitscan.scanner.ScannerFactory;
import com.codexplorer.gitscan.scanner.TaskExtractor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScanService{

	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	CommitRepository commitRepository;
	
	public List<Project> getReadyProjects() {
		return projectRepository.findAll().stream().filter(p -> p.getStatus() == ProjectStatus.ready).collect(Collectors.toList());
	}
	
	public void RunProject(Project project) {
		// Mark Project as Active (in Progress)
		project.setStatus(ProjectStatus.active);
		projectRepository.save(project);
		
		try {
			// run scanner
			Commit commit = ScannerFactory.getScanner(project.getVersioningSystems()).scan(project);
			commitRepository.save(commit);
			// get description from relevant jira task
			//commit.setTicketMessage(TaskTrackerConnectorFactory.getTaskTrackerConnector(project.getTaskTrackingSystem()).getDescription(TaskExtractor.extractTaskId(commit.getCommitMessage()), project.getJiraURL()));
			// mark project as complete
			project.setStatus(ProjectStatus.complete);
		}
		catch (Exception e) {
			project.setStatus(ProjectStatus.failed);
		}
		
		projectRepository.save(project);
	}
	

}
