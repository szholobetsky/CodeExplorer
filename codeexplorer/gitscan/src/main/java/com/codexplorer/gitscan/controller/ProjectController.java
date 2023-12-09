package com.codexplorer.gitscan.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codexplorer.gitscan.model.Project;
import com.codexplorer.gitscan.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProjectController {

	@Autowired
	ProjectRepository projectRepository;

	@GetMapping("/projects")
	public List<Project> getProjects() {

		return projectRepository.findAll();
	}

	@GetMapping("/check")
	public String checkHelth() {

		return "Hello World";
	}
}
