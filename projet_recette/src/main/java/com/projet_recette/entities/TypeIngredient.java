package com.projet_recette.entities;

import org.apache.commons.lang3.EnumUtils;

import com.fasterxml.jackson.annotation.JsonCreator;

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
