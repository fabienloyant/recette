package com.projet_recette.recette;


import java.time.LocalDate;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Recette {
	
	/*
	 * Définition des attributs de la table recettes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_recette")
	private Integer idRecette;
	
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
	private List <IngredientEntity> ingredient;


	
	
	
	@Override
	public String toString() {
		return "RecetteEntity [idRecette=" + idRecette + ", nomRecette=" + nomRecette + ", tempsPreparation="
				+ tempsPreparation + ", tempsCuisson=" + tempsCuisson + ", tempsRepos=" + tempsRepos + ", nbPersonnes="
				+ nbPersonnes + ", consignes=" + consignes + ", dateAjout=" + dateAjout + ", lastUpdate=" + lastUpdate
				+ "]";
	}





	public RecetteEntity(int idRecette, String nomRecette, int tempsPreparation, int tempsCuisson, int tempsRepos,
			int nbPersonnes, String consignes, LocalDate dateAjout, LocalDate lastUpdate,
			List<IngredientEntity> ingredient) {
		this.idRecette = idRecette;
		this.nomRecette = nomRecette;
		this.tempsPreparation = tempsPreparation;
		this.tempsCuisson = tempsCuisson;
		this.tempsRepos = tempsRepos;
		this.nbPersonnes = nbPersonnes;
		this.consignes = consignes;
		this.dateAjout = dateAjout;
		this.lastUpdate = lastUpdate;
		this.ingredient = ingredient;
	}
	
	
	
	

}
