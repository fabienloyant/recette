package com.projet_recette.dto.recette;

import java.time.LocalDate;
import java.util.List;

import com.projet_recette.dto.ingredient.IngredientSansRecetteDto;

import lombok.Data;

@Data
public class RecetteSansUtilisateurDto {
	private Integer idRecette;
	private String Nom;
	private int tempsPreparation;
	private int tempsCuisson;
	private int TempsRepos;
	private int nbPersonnes;
	private String consignes;
	private LocalDate dateAjout;
	private LocalDate lastUpdate;
	
	
	private List<IngredientSansRecetteDto> ingredient;
}
