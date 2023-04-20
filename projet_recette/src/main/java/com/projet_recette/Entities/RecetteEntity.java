package com.projet_recette.Entities;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name ="recettes")
public class RecetteEntity {
	
	/*
	 * Définition des attributs de la table recettes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_recette")
	private int idRecette;
	
	@Column (name = "nom_recette", length = 100 , nullable = false )
	private String nomRecette;
	
	@Column (name ="temps_de_preparation", nullable= true)
	private int tempsPreparation;
	
	@Column (name ="temps_de_cuisson", nullable= true)
	private int tempsCuisson;
	
	@Column (name ="temps_de_repos", nullable= true)
	private int tempsRepos;
	
	@Column (name = "nombre_de_personne", nullable = false)
	private int nbPersonnes;
	
	@Column (name ="consignes", nullable = false)
	private String consignes;
	
	@Column(name ="date_ajout")
	@Temporal(TemporalType.DATE)
	private LocalDate dateAjout;
	
	@Column(name ="date_mis_a_jour")
	@Temporal(TemporalType.DATE)
	private LocalDate lastUpdate;
	
	@ManyToMany
	@JoinTable(name="recettes_ingredients", //table intermédiaire entre recettes et ingredients
		joinColumns = @JoinColumn(name = "id_recette", referencedColumnName = "id_recette"),
		inverseJoinColumns = @JoinColumn(name = "id_ingredient", referencedColumnName = "id_ingredient"))
	private List <IngredientEntity> ingredients;

	@ManyToMany(mappedBy = "recettes")
	private List<UtilisateurEntity> utilisateurs;
	
	public String getNomRecette() {
		return nomRecette;
	}

	public void setNomRecette(String nomRecette) {
		this.nomRecette = nomRecette;
	}

	public int getTempsPreparation() {
		return tempsPreparation;
	}

	public void setTempsPreparation(int tempsPreparation) {
		this.tempsPreparation = tempsPreparation;
	}

	public int getTempsCuisson() {
		return tempsCuisson;
	}

	public void setTempsCuisson(int tempsCuisson) {
		this.tempsCuisson = tempsCuisson;
	}

	public int getTempsRepos() {
		return tempsRepos;
	}

	public void setTempsRepos(int tempsRepos) {
		this.tempsRepos = tempsRepos;
	}

	public int getNbPersonnes() {
		return nbPersonnes;
	}

	public void setNbPersonnes(int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}

	public String getConsignes() {
		return consignes;
	}

	public void setConsignes(String consignes) {
		this.consignes = consignes;
	}

	public LocalDate getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(LocalDate dateAjout) {
		this.dateAjout = dateAjout;
	}

	public LocalDate getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getIdRecette() {
		return idRecette;
	}
	
	
	public List<IngredientEntity> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientEntity> ingredients) {
		this.ingredients = ingredients;
	}

	
	
	public List<UtilisateurEntity> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<UtilisateurEntity> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public RecetteEntity() {
		
	}

	public RecetteEntity(String nomRecette, int tempsPreparation, int tempsCuisson, int tempsRepos, int nbPersonnes,
			String consignes, LocalDate dateAjout, LocalDate lastUpdate) {
		this.setNomRecette(nomRecette);
		this.setTempsPreparation(tempsPreparation);
		this.setTempsCuisson( tempsCuisson);
		this.setTempsRepos (tempsRepos);
		this.setNbPersonnes (nbPersonnes);
		this.setConsignes (consignes);
		this.setDateAjout (dateAjout);
		this.setLastUpdate ( lastUpdate);
	}
	
	public RecetteEntity(String nomRecette, int tempsPreparation, int tempsCuisson, int tempsRepos, int nbPersonnes,
			String consignes, LocalDate dateAjout, LocalDate lastUpdate, List<IngredientEntity> ingredients) {
		this.setNomRecette(nomRecette);
		this.setTempsPreparation(tempsPreparation);
		this.setTempsCuisson( tempsCuisson);
		this.setTempsRepos(tempsRepos);
		this.setNbPersonnes(nbPersonnes);
		this.setConsignes(consignes);
		this.setDateAjout(dateAjout);
		this.setLastUpdate( lastUpdate);
		this.setIngredients(ingredients);
	}
	
	
	@Override
	public String toString() {
		return "RecetteEntity [idRecette=" + idRecette + ", nomRecette=" + nomRecette + ", tempsPreparation="
				+ tempsPreparation + ", tempsCuisson=" + tempsCuisson + ", tempsRepos=" + tempsRepos + ", nbPersonnes="
				+ nbPersonnes + ", consignes=" + consignes + ", dateAjout=" + dateAjout + ", lastUpdate=" + lastUpdate
				+ "ingredietns = " + ingredients + "]";
	}

	
	
	
	
	
	

}
