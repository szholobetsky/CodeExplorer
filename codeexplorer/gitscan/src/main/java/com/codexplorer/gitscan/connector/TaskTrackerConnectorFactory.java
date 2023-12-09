package com.codexplorer.gitscan.connector;

import com.codexplorer.gitscan.scanner.GitScanner;
import com.codexplorer.gitscan.scanner.Scanner;

public class TaskTrackerConnectorFactory {

	public static TaskTrackerConnector getTaskTrackerConnector(String taskTrackerSystem) {
		TaskTrackerConnector tracker = null;
		switch(taskTrackerSystem) {
		case "Jira":
			tracker = new JiraTrackerConnector();
			break;
		case "asana": 
			tracker = null;
			break;
		default:
			tracker = null;
		}
		return tracker;
	}
}
