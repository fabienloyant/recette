package com.projet_recette.utilisateur.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.Data;

@Data
public class UtilisateurReduitDto {

	private int id;
	private String prenom;
	private String nom;
	private Timestamp dateDeNaissance;
	private String login;
	private String mdp;
	private LocalDate dateAjout;
	private LocalDate lastUpdate;
	
}
