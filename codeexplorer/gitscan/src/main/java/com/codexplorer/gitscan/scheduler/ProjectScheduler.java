package com.codexplorer.gitscan.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.codexplorer.gitscan.model.Project;
import com.codexplorer.gitscan.service.ScanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectScheduler {
	
	@Autowired
	ScanService scanService;
	
	@Scheduled(fixedDelay = 300_000)
	public void checkProjects() {
		// TODO: implement logic below
		// get active project from DB
		List<Project> projects = scanService.getReadyProjects();
		for (Project project : projects) {
			scanService.RunProject(project);
		}
	}
	

}
