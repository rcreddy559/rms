	package com.rooms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RoomsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomsManagementApplication.class, args);
	}

}
