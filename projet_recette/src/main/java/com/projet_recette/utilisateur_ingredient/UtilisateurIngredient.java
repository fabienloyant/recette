package com.projet_recette.utilisateur_ingredient;

import com.projet_recette.ingredient.Ingredient;
import com.projet_recette.utilisateur.Utilisateur;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class UtilisateurIngredient {

	
	/*******************************************************************************
	 * Attributs
	 *******************************************************************************/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingredient")
	private int id;

	@Column(name = "quantite", length = 100, nullable = false)
	private double quantite;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	@ManyToOne
	private Ingredient ingredient;
	
	/***************************************************************************
	 * Constructeurs
	 ****************************************************************************/
	
	public UtilisateurIngredient(int id, double quantite, Utilisateur utilisateur, Ingredient ingredient) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.utilisateur = utilisateur;
		this.ingredient = ingredient;
	}

}
