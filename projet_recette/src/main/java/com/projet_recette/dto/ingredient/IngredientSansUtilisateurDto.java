package com.projet_recette.dto.ingredient;

import java.util.List;

import com.projet_recette.dto.recette.RecetteSansIngredientDto;
import com.projet_recette.entities.TypeIngredient;
import com.projet_recette.entities.Unite;

import lombok.Data;

@Data
public class IngredientSansUtilisateurDto {

	private int id;
	private String nom; 
	private Unite unite;
	private TypeIngredient typeIngredient;
	
	private List<RecetteSansIngredientDto> recette;

}