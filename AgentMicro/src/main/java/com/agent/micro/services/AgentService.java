package com.agent.micro.services;
import java.util.List;
import java.util.Optional;

import com.agent.micro.entities.Agent;

public interface AgentService {
	
	List<Agent> getAllAgents();
	Optional<Agent> getAgentsById(Long id);
	void saveOrUpdateAgent(Agent agent);
	void deleteAgent(Long id);

}
