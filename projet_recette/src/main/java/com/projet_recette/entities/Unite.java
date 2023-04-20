package com.projet_recette.entities;

public enum Unite {

	INGREDIENT("Ingrédient"),
	ML("Millilitre"),
	G("Gramme");
	
	private String libelle;
	
	//constructeurs
	private Unite(String libelle) {
		this.libelle = libelle;
	}

	//getter
	public String getLibelle() {
		return libelle;
	}

}
