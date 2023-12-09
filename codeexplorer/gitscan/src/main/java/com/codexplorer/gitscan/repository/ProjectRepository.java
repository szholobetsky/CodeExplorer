package com.codexplorer.gitscan.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codexplorer.gitscan.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	public List<Project> findAll();

}
