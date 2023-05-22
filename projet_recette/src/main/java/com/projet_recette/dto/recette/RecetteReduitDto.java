package com.projet_recette.dto.recette;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RecetteReduitDto {
	
	private Integer idRecette;
	private String Nom;
	private int tempsPreparation;
	private int tempsCuisson;
	private int TempsRepos;
	private int nbPersonnes;
	private String consignes;
	private LocalDate dateAjout;
	private LocalDate lastUpdate;
	
	
	
}
