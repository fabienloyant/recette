package com.projet_recette.dto.ingredient;

import java.util.List;
import java.util.ArrayList;

import com.projet_recette.dto.recette.RecetteSansIngredientDto;
import com.projet_recette.dto.utilisateur.UtilisateurSansIngredientDto;
import com.projet_recette.entities.TypeIngredient;
import com.projet_recette.entities.Unite;

import lombok.Data;

@Data
public class IngredientCompletDto {

	private int id;
	private String nom;
	private Unite unite;
	private TypeIngredient typeIngredient;
	
	private double quantite;
	
	private List<RecetteSansIngredientDto> recette = new ArrayList<>();
	
	private List<UtilisateurSansIngredientDto> utilisateur = new ArrayList<>();
	

}
