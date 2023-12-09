package com.codexplorer.gitscan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GitscanApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitscanApplication.class, args);
	}

}
