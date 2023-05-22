package com.projet_recette.dto.ingredient;

import com.projet_recette.entities.TypeIngredient;
import com.projet_recette.entities.Unite;

import lombok.Data;

@Data
public class IngredientReduitDto {

	private int id;
	private String nom; 
	private Unite unite;
	private TypeIngredient typeIngredient;

}
