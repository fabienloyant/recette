package com.projet_recette.entities;

import java.util.List;

import javax.persistence.*;


	/**********************************************************************************
	 * création de la table
	 ********************************************************************************/

@Entity 
@Table(name="ingredients") 
public class IngredientEntity {
	
	
	/*******************************************************************************
	 * Attributs
	 *******************************************************************************/	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column (name ="id_ingredient")
	private int id;

	@Column(name="nom", length = 100, nullable = false)
	private String nom;
	
	@Column(name="unite", length = 50, nullable = false)
	private Unite unite; //enum
	
	@Column(name="type_ingredient", length = 50, nullable = false)
	private TypeIngredient typeIngredient; //enum
	
	@ManyToMany (mappedBy = "recettes") //mappé sur l'autre entité recettes
	private List <RecetteEntity> recettes;
	
	@ManyToMany (mappedBy = "utilisateurs")
	private List <UtilisateurEntity> utilisateurs;
	
	
	
	/************************************************************************************
	 * constructeurs
	 ********************************************************************************/
	
	public IngredientEntity() {};
	
	public IngredientEntity(String nom, Unite unite, TypeIngredient typeIngredient) {
		this.nom = nom;
		this.unite = unite;
		this.typeIngredient = typeIngredient;
	}
	
	//avec recettes
	public IngredientEntity(String nom, Unite unite, TypeIngredient typeIngredient, List<RecetteEntity> recettes) {
		this.nom = nom;
		this.unite = unite;
		this.typeIngredient = typeIngredient;
		this.recettes = recettes;
	}
	

	//avec recette et user
	public IngredientEntity(String nom, Unite unite, TypeIngredient typeIngredient, List<RecetteEntity> recettes, List<UtilisateurEntity> utilisateurs) {
		this.nom = nom;
		this.unite = unite;
		this.typeIngredient = typeIngredient;
		this.recettes = recettes;
		this.utilisateurs = utilisateurs;
	}
	
	
	/************************************************************************************
	 * getter et setter
	 ********************************************************************************/
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Unite getUnite() {
		return unite;
	}
	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	public TypeIngredient getTypeIngredient() {
		return typeIngredient;
	}
	public void setTypeIngredient(TypeIngredient typeIngredient) {
		this.typeIngredient = typeIngredient;
	}

	public int getId() {
		return id;
	}

	public List<RecetteEntity> getRecettes() {
		return recettes;
	}
	public void setRecettes(List<RecetteEntity> recettes) {
		this.recettes = recettes;
	}
	
	public List<UtilisateurEntity> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<UtilisateurEntity> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	/*****************************************************************
	 * Méthode to string
	 *****************************************************************/
	
	@Override
	public String toString() {
		return "IngredientEntity [id=" + id 
				+ ", nom=" + nom 
				+ ", unite=" + unite 
				+ ", typeIngredient=" + typeIngredient	+ "]";
	}
	
}
