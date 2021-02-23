package com.matt.springmasterclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringMasterclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMasterclassApplication.class, args);
	}

}
