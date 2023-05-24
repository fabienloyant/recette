package com.projet_recette.dto.recette;

import java.time.LocalDate;
import java.util.List;

import com.projet_recette.dto.ingredient.IngredientSansRecetteDto;
import com.projet_recette.dto.utilisateur.UtilisateurSansRecetteDto;

import lombok.Data;

@Data
public class RecetteCompletDto {
	
	private Integer idRecette;
	private String Nom;
	private int tempsPreparation;
	private int tempsCuisson;
	private int TempsRepos;
	private int nbPersonnes;
	private String consignes;
	private LocalDate dateAjout;
	private LocalDate lastUpdate;
	private double quantite;
	
	private List<IngredientSansRecetteDto> ingredient;

	private List<UtilisateurSansRecetteDto> utilisateur;
}
