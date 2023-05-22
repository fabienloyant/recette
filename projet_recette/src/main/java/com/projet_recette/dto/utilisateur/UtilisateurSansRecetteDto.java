package com.projet_recette.dto.utilisateur;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import com.projet_recette.dto.ingredient.IngredientReduitDto;

import lombok.Data;

@Data
public class UtilisateurSansRecetteDto {

	private int id;
	private String prenom;
	private String nom;
	private Timestamp dateDeNaissance;
	private String login;
	private String mdp;
	private LocalDate dateAjout;
	private LocalDate lastUpdate;
	private List <IngredientReduitDto> ingredients;
	
}
