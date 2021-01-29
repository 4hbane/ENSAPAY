package com.agent.micro.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agent.micro.entities.Agent;
import com.agent.micro.services.AgentService;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/Agent/*")
public class AgentController {
	
	@Autowired
	private AgentService agentService;
	
	@GetMapping(value="/Agents")
	public ResponseEntity<List<Agent>> getAllAgents(){
		
		List<Agent> agents = agentService.getAllAgents();
		return new ResponseEntity<List<Agent>>(agents,HttpStatus.FOUND);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?>getAgentById(@PathVariable Long id){
		
		Optional<Agent> agent =agentService.getAgentsById(id);
		if(agent.isPresent()) {
			return new ResponseEntity<Agent>(agent.get(), HttpStatus.FOUND);
			
		}
		else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping(value="/addAgent")
	@Transactional
	public ResponseEntity<?> addAdmin(@RequestBody Agent agent){
		agentService.saveOrUpdateAgent(agent);
		return new ResponseEntity<Agent>(agent,HttpStatus.OK);
			
	}
	
	@DeleteMapping(value="/{id}/deleteAgent")
	public ResponseEntity<?> deleteAgent(@PathVariable Long id){
		
		Optional<Agent> agent=agentService.getAgentsById(id);
		agentService.deleteAgent(id);
		return new ResponseEntity<Agent>(agent.get(),HttpStatus.ACCEPTED);
		
		
	}
	
	
}
