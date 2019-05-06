package com.yao.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootStudyApplication {

	public static void main(String[] args) {
		// 包括以下3个注解，@SpringBootConfiguration 等同 @Configuration
		// @EnableAutoConfiguration
		// @ComponentScan
		SpringApplication.run(SpringbootStudyApplication.class, args);
	}

}
