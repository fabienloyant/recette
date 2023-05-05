package com.projet_recette.utilisateur;

import java.time.LocalDate;
import java.util.List;

import com.projet_recette.ingredient.Ingredient;
import com.projet_recette.recette.Recette;
import com.projet_recette.utilsateur_recette.RecetteUtilisateur;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	private LocalDate dateDeNaissance;

	@Column(name="login", length = 50, nullable = false)
	private String login;
	
	@Column(name="mdp", length = 50, nullable = false)
	private String mdp;
	
	@Column(name="date_ajout", length = 50, nullable = false)
	private LocalDate dateAjout = LocalDate.now();
	
	@Column(name="last_update", length = 50, nullable = false)
	private LocalDate lastUpdate = LocalDate.now();
	
	
	@OneToMany(mappedBy = "utilisateur")
	private List<RecetteUtilisateur> recetteUtilisateur ;
	
	
	public Utilisateur(String prenom, String nom, LocalDate dateDeNaissance, String login, String mdp) {
		this.prenom = prenom;
		this.nom = nom;
		this.dateDeNaissance = dateDeNaissance;
		this.login = login;
		this.mdp = mdp;
	}

	
	
}
