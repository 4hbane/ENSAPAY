package com.agent.micro.controllers;

import com.agent.micro.ExternalServices.User;
import com.agent.micro.ExternalServices.authService;
import com.agent.micro.entities.Agent;
import com.agent.micro.repositories.AgentRepository;
import com.agent.micro.security.CurrentJWT;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api")
public class AgentController {

	 private final AgentRepository agentRepository;
	// private final authService authService;
	// private final CurrentJWT currentJWT;

	@GetMapping(value="/agents")
	public ResponseEntity<List<Agent>> getAllAgents(){
		List<Agent> agents = agentRepository.findAll ();
		return new ResponseEntity<List<Agent>>(agents,HttpStatus.FOUND);
	}
	
	@GetMapping(value="/agents/{id}")
	public ResponseEntity<?>getAgentById(@PathVariable Long id){
		Optional<Agent> agent = agentRepository.findById ( id );
		if(agent.isPresent()) {
			return new ResponseEntity<Agent>(agent.get(), HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value="/agents")
	@Transactional
	public ResponseEntity<?> addAdmin(@RequestBody Agent agent, HttpServletRequest request){
		agent.setId ( null );
		Agent agentCreated = agentRepository.save ( agent );
		if (agentCreated != null) { // Create its login where username is phoneNumber and password is CIN.
			// authService.createUserLogin ( currentJWT.getJWT ( request ), new User ( agent.getTelephone (), agent.getNumPieceIdentite () ) );
			return new ResponseEntity<Agent>(agent,HttpStatus.OK);
		}
		return new ResponseEntity<Agent>(agent,HttpStatus.BAD_REQUEST);
	}


	@PutMapping(value="/agents/{id}")
	public ResponseEntity<?> editAgent(@PathVariable Long id, @RequestBody Agent agent){
		if (agentRepository.existsById ( id )){
			Agent agentBeforeEdit = agentRepository.findById ( id ).get ();
			agent.setId ( agentBeforeEdit.getId () );
			agentRepository.save ( agent );
			return new ResponseEntity<Agent>(agent,HttpStatus.OK);
		}
		return new ResponseEntity<Agent>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value="/agents/{id}")
	public ResponseEntity<?> deleteAgent(@PathVariable Long id, HttpServletRequest request){
		if (agentRepository.existsById ( id )){
			Agent accountToDelete = agentRepository.findById ( id ).get ();
			agentRepository.deleteById (id);
			// authService.deleteUserLogin ( currentJWT.getJWT ( request ), accountToDelete.getTelephone ()); // Delete also his login in auth-service !
			return new ResponseEntity<Agent>(HttpStatus.OK);
		}
		return new ResponseEntity<Agent>(HttpStatus.NOT_FOUND);
	}


}
