package com.hackathon.quirk.blackbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BlackboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackboxApplication.class, args);
	}

}
