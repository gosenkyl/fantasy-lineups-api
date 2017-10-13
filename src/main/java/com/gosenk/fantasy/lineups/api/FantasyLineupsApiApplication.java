package com.gosenk.fantasy.lineups.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.gosenk.fantasy.lineups.api.repository"})
@ComponentScan("com.gosenk.fantasy.lineups.api")
@EntityScan(basePackages = "com.gosenk.fantasy.lineups.api.entity")
public class FantasyLineupsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FantasyLineupsApiApplication.class, args);
	}
}
