package com.codexplorer.gitscan.scanner;

import java.io.IOException;

import com.codexplorer.gitscan.model.Commit;
import com.codexplorer.gitscan.model.Project;

public interface Scanner {

	public Commit scan(Project project) throws IOException;
}
