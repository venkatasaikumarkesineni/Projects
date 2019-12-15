package com.hcl.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableEurekaClient
@SpringBootApplication
public class ClientUiApplication implements WebMvcConfigurer{
	public static final String serviceUrl = "http://user-services";

	public static void main(String[] args) {
		SpringApplication.run(ClientUiApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public ClientRepository clientRepository() {
		return new ClientRepositoryImpl(serviceUrl);
	}

}
