package com.codexplorer.gitscan.model;

public enum ProjectStatus {
	
	pending(0),
	ready(1),
	active(2),
	complete(3),
	failed(4),
	canceled(5);
	
    public final Integer value;

    private ProjectStatus(Integer value) {
        this.value = value;
    }
	
}
