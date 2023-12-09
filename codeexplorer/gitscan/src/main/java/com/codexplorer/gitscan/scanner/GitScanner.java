package com.codexplorer.gitscan.scanner;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GHCommit.File;
import org.springframework.stereotype.Component;

import com.codexplorer.gitscan.model.ChangedFile;
import com.codexplorer.gitscan.model.Commit;
import com.codexplorer.gitscan.model.Project;

@Component
public class GitScanner implements Scanner {
	
	private GitHub connect() throws IOException {
		String accessToken = "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";
		GitHub github = null;
		github = GitHub.connectUsingOAuth(accessToken);
		return github;
	}
	
	@Override
	public Commit scan(Project project) throws IOException {		
		String owner = project.getOwner();
		String repo = project.getRepositoryName();
		GitHub github = connect();
		String ownerName = owner;
		String repositoryName = repo;
		GHRepository repository = github.getRepository(ownerName + "/" + repositoryName);
		Commit commitDB = new Commit(); 
		
		List<GHCommit> commits = repository.listCommits().toList().stream().limit(10).toList();
		
		for (GHCommit commit : commits) {
			// Get the commit message
			String commitMessage = commit.getCommitShortInfo().getMessage();
		
			// Get the list of files in the commit
			List<File> commitFiles = commit.getFiles();
		
			commitDB.setAuthor(commit.getAuthor().getName());
			commitDB.setCommitMessage(commitMessage);
			commitDB.setGitId(commit.getSHA1().toString());
			commitDB.setGitUrl(commit.getHtmlUrl().toString());
			Set<ChangedFile> changes = new HashSet<ChangedFile>();
			// Iterate over the files and access their information
			for (File file : commitFiles) {
			    String wholeFileName = file.getFileName();
			    String status = file.getStatus();
			    String fileName = FileUtil.getFileName(wholeFileName);
			    String path = FileUtil.getFilePath(wholeFileName);
			    String fileType = FileUtil.getFileExtension(wholeFileName);
			    // Print file information
			    ChangedFile changedFile = new ChangedFile();
			    changedFile.setFileName(fileName);
			    changedFile.setFilePath(path);
			    changedFile.setFileStatus(status);
			    changedFile.setFileType(fileType);
			    changes.add(changedFile);
			}
			commitDB.setChanges(changes);
			commitDB.setProject(project);
		}
		
		return commitDB;
	}
}

