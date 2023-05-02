package com.projet_recette.ingredient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**********************************************************************************
 * création de la table
 ********************************************************************************/

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ingredient {

	
	/*******************************************************************************
	 * Attributs
	 *******************************************************************************/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingredient")
	private int id;

	@Column(name = "nom", length = 100, nullable = false)
	private String nom;

	@Column(name = "unite", length = 50, nullable = false)
	private Unite unite; // enum

	@Column(name = "type_ingredient", length = 50, nullable = false)
	private TypeIngredient typeIngredient; // enum

	
	/***************************************************************************
	 * Constructeurs
	 ****************************************************************************/
	public Ingredient(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	public Ingredient(int id, String nom, Unite unite) {
		super();
		this.id = id;
		this.nom = nom;
		this.unite = unite;
	}
	
	public Ingredient(int id, String nom, Unite unite, TypeIngredient typeIngredient) {
		super();
		this.id = id;
		this.nom = nom;
		this.unite = unite;
		this.typeIngredient = typeIngredient;
	}
	
	
	
	/*****************************************************************
	 * Méthode to string
	 *****************************************************************/

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", nom=" + nom + ", unite=" + unite + ", typeIngredient=" + typeIngredient
				+ "]";
	}

}
