package com.projet_recette.entities;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="utilisateurs")
public class UtilisateurEntity {

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
	private List <IngredientEntity> ingredients; // TO IMPORT
	
	@ManyToMany
	@JoinTable(name="utilisateurs_recettes",
		joinColumns = @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur"),
		inverseJoinColumns = @JoinColumn(name = "id_recette", referencedColumnName = "id_recette"))
	private List <RecetteEntity> recettes; // TO IMPORT
	
	public UtilisateurEntity(String prenom, String nom, Timestamp dateDeNaissance, String login, String mdp,
			LocalDate dateAjout, LocalDate lastUpdate) {
		this.prenom = prenom;
		this.nom = nom;
		this.dateDeNaissance = dateDeNaissance;
		this.login = login;
		this.mdp = mdp;
		this.dateAjout = dateAjout;
		this.lastUpdate = lastUpdate;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Timestamp getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Timestamp dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public LocalDate getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getId() {
		return id;
	}

	public LocalDate getDateAjout() {
		return dateAjout;
	}

	@Override
	public String toString() {
		return "UtilisateurEntity [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", dateDeNaissance="
				+ dateDeNaissance + ", login=" + login + ", mdp=" + mdp + ", dateAjout=" + dateAjout + ", lastUpdate="
				+ lastUpdate + "]";
	}
	
}
