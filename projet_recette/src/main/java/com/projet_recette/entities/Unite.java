package com.projet_recette.entities;

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
