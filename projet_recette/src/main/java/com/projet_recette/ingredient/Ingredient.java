package com.projet_recette.ingredient;

import java.util.List;

import com.projet_recette.ingredient_recette.IngredientRecette;
import com.projet_recette.recette.Recette;
import com.projet_recette.utilisateur.Utilisateur;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**********************************************************************************
 * création de la table
 ********************************************************************************/

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
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
	
	
	@OneToMany
	private List<IngredientRecette> ingredientRecette;
	
	//@OneToMany
	//private List <UtilisateurIngredient> UtilisateurIngredient;
	
//	@ManyToMany(mappedBy = "ingredient")
//	private List<Utilisateur> utilisateur ;
//	
//	@ManyToMany (mappedBy = "ingredient")
//	private List <Recette> recette;

	
	/***************************************************************************
	 * Constructeurs
	 ****************************************************************************/

	public Ingredient(int id, String nom, Unite unite, TypeIngredient typeIngredient, //UtilisateurIngredient utilisateurIngredient,
			List<IngredientRecette> ingredientRecette) {
		this.id = id;
		this.nom = nom;
		this.unite = unite;
		this.typeIngredient = typeIngredient;
		//this.UtilisateurIngredient = utilisateurIngredient;
		this.ingredientRecette = ingredientRecette;
	}

}
