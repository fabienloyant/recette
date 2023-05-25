package com.projet_recette.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.apache.commons.lang3.*;

import lombok.Getter;

@Getter
public enum Unite {

	INGREDIENT("Ingrédient"), ML("Millilitre"), G("Gramme");

	private String libelle;

	// constructeurs
	private Unite(String libelle) {
		this.libelle = libelle;
	}
	
	
	
}
