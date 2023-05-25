package com.projet_recette.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum Unite {

	INGREDIENT("Ingrédient"), ML("Millilitre"), G("Gramme");

	private String libelle;

	// constructeurs
	private Unite(String libelle) {
		this.libelle = libelle;
	}
//	@JsonCreator
//	private static Unite forValue(String name) {
//		return EnumUtil.getEnumByNameIgnoreCase(Unite.class, name);
//	}
	
}
