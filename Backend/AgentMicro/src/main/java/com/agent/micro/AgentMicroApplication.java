package com.agent.micro;


import com.agent.micro.entities.Agent;
import com.agent.micro.repositories.AgentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class AgentMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run ( AgentMicroApplication.class, args );
	}


	@Bean
	CommandLineRunner start(AgentRepository agentRepository) {
		return args -> {
			agentRepository.save ( new Agent ( null, "ahbane", "abdou", "CIN", "JC36784", "11-12-2020", "Taroudant, Maroc", "abdellah@ahbane.me", "0600001111", "immRegis-77883", "numPatente-78939", "Description", "piece url" ) );
		};
	}
}
