package com.projet_recette.utilisateur;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import com.projet_recette.ingredient.Ingredient;
import com.projet_recette.recette.Recette;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilisateur")
	private int id;
	
	@Column(name="prenom", length = 50, nullable = false)
	private String prenom;
	
	@Column(name="nom", length = 50, nullable = false)
	private String nom;
	
	@Column(name="date_de_naissance", nullable = false)
	private Timestamp dateDeNaissance;

	@Column(name="login", length = 50, nullable = false)
	private String login;
	
	@Column(name="mdp", length = 50, nullable = false)
	private String mdp;
	
	@Column(name="date_ajout", length = 50, nullable = false)
	private LocalDate dateAjout;
	
	@Column(name="last_update", length = 50, nullable = false)
	private LocalDate lastUpdate;
	
	@ManyToMany
	@JoinTable(name="utilisateurs_ingredients",
		joinColumns = @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur"),
		inverseJoinColumns = @JoinColumn(name = "id_ingredient", referencedColumnName = "id_ingredient"))
	private List <Ingredient> ingredients;
	
	@ManyToMany
	@JoinTable(name="utilisateurs_recettes",
		joinColumns = @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur"),
		inverseJoinColumns = @JoinColumn(name = "id_recette", referencedColumnName = "id_recette"))
	private List <Recette> recettes;
	
	public Utilisateur(String prenom, String nom, Timestamp dateDeNaissance, String login, String mdp,
			LocalDate dateAjout, LocalDate lastUpdate) {
		this.prenom = prenom;
		this.nom = nom;
		this.dateDeNaissance = dateDeNaissance;
		this.login = login;
		this.mdp = mdp;
		this.dateAjout = dateAjout;
		this.lastUpdate = lastUpdate;
	}

	
	
}
