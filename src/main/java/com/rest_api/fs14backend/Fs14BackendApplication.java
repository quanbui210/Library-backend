package com.rest_api.fs14backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@Import(CorsConfig.class)

public class Fs14BackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(Fs14BackendApplication.class, args);
	}
}
