package com.projet_recette.ingredient.dto;

import com.projet_recette.ingredient.TypeIngredient;
import com.projet_recette.ingredient.Unite;

import lombok.Data;

@Data
public class IngredientReduitDto {

	private int id;
	private String nom; 
	private Unite unite;
	private TypeIngredient typeIngredient;

}
