package com.projet_recette.ingredient.dto;

import java.util.List;

import com.projet_recette.ingredient.TypeIngredient;
import com.projet_recette.ingredient.Unite;
import com.projet_recette.utilisateur.dto.UtilisateurSansIngredientDto;

import lombok.Data;

@Data
public class IngredientSansRecetteDto {

	private int id;
	private String nom; 
	private Unite unite;
	private TypeIngredient typeIngredient;
	
	private List <UtilisateurSansIngredientDto> utilisateurs;

}
