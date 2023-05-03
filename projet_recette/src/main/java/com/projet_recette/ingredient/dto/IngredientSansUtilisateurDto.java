package com.projet_recette.ingredient.dto;

import java.util.List;

import com.projet_recette.ingredient.TypeIngredient;
import com.projet_recette.ingredient.Unite;

import lombok.Data;

@Data
public class IngredientSansUtilisateurDto {

	private int id;
	private String nom; 
	private Unite unite;
	private TypeIngredient typeIngredient;
	
	private List<RecetteSansIngredientDto> recette;

}
