package com.agent.micro.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.agent.micro.AgentException;
import com.agent.micro.entities.Agent;
import com.agent.micro.repositories.AgentRepository;

@Service
public class AgentServiceImpl implements AgentService{
	
	private static final Logger logger = LoggerFactory.getLogger(AgentServiceImpl.class);
	
	@Autowired
	private AgentRepository agentRepository;

	@Override
	public List<Agent> getAllAgents() {
		List<Agent> agents=agentRepository.findAll();
		if(agents.isEmpty())
		return null;
		return agents;
	}

	@Override
	public Optional<Agent> getAgentsById(Long id) throws AgentException{
		Optional<Agent> agents = agentRepository.findById(id);
		if (Boolean.FALSE.equals(agents.isPresent())){
			throw new AgentException("User Not Found","Aucun utilisateur avec l'identifiant :" + id);
			}
	        
			return agents;
	}

	@Override
	public void saveOrUpdateAgent(Agent agent) throws AgentException{
		
		List<Agent> ag = agentRepository.findAll();
		for(Agent a:ag) {
			if(a.getEmail().equals(agent.getEmail())) {
				throw new AgentException("Email déjà existant");
			}else {
				if(a.getNumPieceIdentite().equals(agent.getNumPieceIdentite())) {
					throw new AgentException("Numéro pièce identité déjà existant");
				}else {
					agentRepository.save(agent);
				}
			}
		}
		
	}

	@Override
	public void deleteAgent(Long id) throws AgentException{
		try {
			agentRepository.deleteById(id);
		}catch(EmptyResultDataAccessException ex) {
			logger.error(String.format("Aucun Agent n'existe avec l'identifiant: "+id, ex));
			throw new AgentException("DeleteUserError", "Erreur de suppression de l'Agent  avec l'identifiant: "+id, HttpStatus.NOT_FOUND);
		}
		
		
	}

}
