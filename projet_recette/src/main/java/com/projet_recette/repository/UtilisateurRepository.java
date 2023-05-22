package com.projet_recette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_recette.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	
	//Utilisateur findByLogin(String login);
}