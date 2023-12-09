package com.codexplorer.gitscan.scanner;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    public static String getFileName(String filePath) {
    	Path path = Paths.get(filePath);

        String fileName = path.getFileName().toString();
        return fileName;
    }
    
    public static String getFilePath(String filePath) {
    	Path path = Paths.get(filePath);

    	String fileDirectory = path.getParent().toString();
    	return fileDirectory;
    }
    
    public static String getFileExtension(String filePath) {
    	String fileName = getFileName(filePath);
    	int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex != -1 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex + 1);
        }
        return "";
    }
}
