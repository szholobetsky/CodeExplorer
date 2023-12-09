package com.codexplorer.gitscan.scanner;

public class ScannerFactory {

	public static Scanner getScanner(String versioningSystem) {
		Scanner scanner = null;
		switch(versioningSystem) {
		case "GitHub":
			scanner = new GitScanner();
			break;
		case "SVN": 
			scanner = null;
			break;
		default:
			scanner = null;
		}
		return scanner;
	}
}
