package com.projet_recette.recette;


import java.time.LocalDate;
import java.util.List;

import com.projet_recette.ingredient.Ingredient;
import com.projet_recette.utilisateur.Utilisateur;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
	@JoinTable(name="recette_ingredient", //table intermédiaire entre recette et ingredient
		joinColumns = @JoinColumn(name = "id_recette", referencedColumnName = "id_recette"),
		inverseJoinColumns = @JoinColumn(name = "id_ingredient", referencedColumnName = "id_ingredient"))
	private List <Ingredient> ingredient;
	
	@ManyToMany(mappedBy = "recette")
	private List<Utilisateur> utilisateur ;

	public Recette(Integer idRecette, String nomRecette, int tempsPreparation, int tempsCuisson, int tempsRepos,
			int nbPersonnes, String consignes, LocalDate dateAjout, LocalDate lastUpdate) {
		super();
		this.idRecette = idRecette;
		this.nomRecette = nomRecette;
		this.tempsPreparation = tempsPreparation;
		this.tempsCuisson = tempsCuisson;
		this.tempsRepos = tempsRepos;
		this.nbPersonnes = nbPersonnes;
		this.consignes = consignes;
		this.dateAjout = dateAjout;
		this.lastUpdate = lastUpdate;
	}
	
	public Recette(int idRecette, String nomRecette, int tempsPreparation, int tempsCuisson, int tempsRepos,
			int nbPersonnes, String consignes, LocalDate dateAjout, LocalDate lastUpdate,
			List<Ingredient> ingredient) {
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


	public Recette(Integer idRecette, String nomRecette, int tempsPreparation, int tempsCuisson, int tempsRepos,
			int nbPersonnes, String consignes, LocalDate dateAjout, LocalDate lastUpdate,
			List<Utilisateur> utilisateur) {
		
		this.idRecette = idRecette;
		this.nomRecette = nomRecette;
		this.tempsPreparation = tempsPreparation;
		this.tempsCuisson = tempsCuisson;
		this.tempsRepos = tempsRepos;
		this.nbPersonnes = nbPersonnes;
		this.consignes = consignes;
		this.dateAjout = dateAjout;
		this.lastUpdate = lastUpdate;
		this.utilisateur = utilisateur;
	}

	public Recette(Integer idRecette, String nomRecette, int tempsPreparation, int tempsCuisson, int tempsRepos,
			int nbPersonnes, String consignes, LocalDate dateAjout, LocalDate lastUpdate, List<Ingredient> ingredient,
			List<Utilisateur> utilisateur) {
		
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
		this.utilisateur = utilisateur;
	}
	
	

}
