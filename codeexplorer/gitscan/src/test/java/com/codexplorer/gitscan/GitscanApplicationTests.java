package com.codexplorer.gitscan;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codexplorer.gitscan.model.Project;
import com.codexplorer.gitscan.service.ScanService;

@SpringBootTest
class GitscanApplicationTests {

	@Autowired
	ScanService scanService;
	
	@Test
	void contextLoads() {
	}

	@Disabled
	@Test
	void databaseConnection() {
		List<Project> projects = scanService.getReadyProjects();
		for (Project project : projects) {
			scanService.RunProject(project);
		}
	}
	
}
