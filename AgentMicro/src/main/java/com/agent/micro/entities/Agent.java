package com.agent.micro.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Agent {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String typePieceIdentite;
	private String numPieceIdentite;
	private String dateNaissance;
	private String adresse;
	private String email;
	private String telephone;
	private String immRegistre;
	private String numPatente;
	private String description;
	private String pieceUrl;

	
	

}
