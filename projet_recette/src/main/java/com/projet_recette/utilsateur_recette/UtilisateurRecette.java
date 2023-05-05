package com.projet_recette.utilsateur_recette;

import com.projet_recette.recette.Recette;
import com.projet_recette.utilisateur.Utilisateur;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class UtilisateurRecette{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@ManyToOne
		@JoinColumn(name = "utilisateur_id")
		private Utilisateur utilisateur;
		
		@ManyToOne
		@JoinColumn(name = "recette_id")
		private Recette recette;
}
