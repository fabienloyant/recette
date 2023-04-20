package com.projet_recette.entities;

public enum TypeIngredient {
	
	LEGUME("Légume"),
	FRUIT("Fruit"),
	FECULENT("Féculent"),
	LEGUMINEUSE("Légumineuse"),
	VIANDE("Viande"),
	POISSON("Poisson"),
	LAITAGE("Laitage"),
	EPICE("Epice"),
	BOISSON("Boisson");
	
	//attribut
	private String libelle;
	
	//constructeur
	private TypeIngredient(String libelle) {
		this.libelle = libelle;
	}

	//getter
	public String getLibelle() {
		return libelle;
	}

}
