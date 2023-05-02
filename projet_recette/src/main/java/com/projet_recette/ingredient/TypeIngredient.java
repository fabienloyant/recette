package com.projet_recette.ingredient;

import lombok.Getter;

@Getter
public enum TypeIngredient {

	LEGUME("Légume"), FRUIT("Fruit"), FECULENT("Féculent"), LEGUMINEUSE("Légumineuse"), VIANDE("Viande"),
	POISSON("Poisson"), LAITAGE("Laitage"), EPICE("Epice"), BOISSON("Boisson");

	// attribut
	private String libelle;

	// constructeur
	private TypeIngredient(String libelle) {
		this.libelle = libelle;
	}

}
