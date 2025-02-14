package com.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaAutoServiceRegistration;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaServiceRegistry;
import org.springframework.context.annotation.Bean;

import com.netflix.discovery.EurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	@ConditionalOnBean(EurekaClient.class)
	public EurekaAutoServiceRegistration eurekaAutoServiceRegistration(EurekaServiceRegistry registry) {
		return new EurekaAutoServiceRegistration(null, registry, null);
	}

}
