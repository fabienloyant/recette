package com.projet_recette.entities;


import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@ToString
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
	
	@Column (name ="consignes", columnDefinition = "LONGTEXT", nullable = false)
	private String consignes;
	
	@Column(name ="date_ajout")
	@Temporal(TemporalType.DATE)
	private LocalDate dateAjout = LocalDate.now();
	
	@Column(name ="date_mis_a_jour")
	@Temporal(TemporalType.DATE)
	private LocalDate lastUpdate = LocalDate.now();
	
	

	
	

}
