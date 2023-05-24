package com.projet_recette.dto.utilisateur;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import com.projet_recette.dto.ingredient.IngredientReduitDto;
import com.projet_recette.dto.recette.RecetteReduitDto;

import lombok.Data;

@Data
public class UtilisateurCompletDto {
	
	private int id;
	private String prenom;
	private String nom;
	private LocalDate dateDeNaissance;
	private String login;
	private String mdp;
	private LocalDate dateAjout;
	private LocalDate lastUpdate;
	private List <IngredientReduitDto> ingredients;
	private List <RecetteReduitDto> recettes;
	
}
