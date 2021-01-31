package com.agent.micro.entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nom;
	@NotNull
	private String prenom;
	@NotNull
	private String typePieceIdentite;
	@NotNull
	@Column(unique = true)
	private String numPieceIdentite;
	@NotNull
	private String dateNaissance;
	@NotNull
	private String adresse;
	@Column(unique = true)
	private String email;
	@NotNull
	private String telephone;
	@NotNull
	private String immRegistre;
	@NotNull
	private String numPatente;
	@NotNull
	private String description;
	@NotNull
	private String pieceUrl;
}
