package com.ust.skillhive;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configurable
@EnableSwagger2
public class InstructorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstructorApplication.class, args);
		
	}

}
