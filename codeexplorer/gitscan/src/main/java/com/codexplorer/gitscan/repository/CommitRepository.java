package com.codexplorer.gitscan.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codexplorer.gitscan.model.Commit;

public interface CommitRepository extends CrudRepository<Commit, Long> {
	public List<Commit> findAll();
	
}