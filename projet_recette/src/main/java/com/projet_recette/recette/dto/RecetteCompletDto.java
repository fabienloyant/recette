package com.projet_recette.recette.dto;

import java.time.LocalDate;
import java.util.List;

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
	
	private List<IngredientSansRecetteDto> ingredient;

	private List<UtilisateurSansRecetteDto> utilisateur;
}
