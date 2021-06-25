package com.experimentality.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.experimentality.*"})
@EntityScan(basePackages = { "com.experimentality.*" })
@EnableJpaRepositories(basePackages = { "com.experimentality.*" })
@SpringBootApplication
public class ExperimentalityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExperimentalityApplication.class, args);
	}

}
