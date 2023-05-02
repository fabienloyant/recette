package com.projet_recette.ingredient;

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
