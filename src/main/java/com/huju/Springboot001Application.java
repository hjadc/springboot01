package com.huju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Springboot001Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot001Application.class, args);
	}
}
