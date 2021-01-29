package com.agent.micro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.agent.micro.entities.Agent;

@RepositoryRestResource
public interface AgentRepository extends JpaRepository<Agent, Long>{

}
