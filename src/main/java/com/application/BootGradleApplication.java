/**
 * author: Alhajras Algdairy
 * 
 * This is the main class, where the Spring-boot starts with
 */

package com.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BootGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootGradleApplication.class, args);
		 
	}

}
