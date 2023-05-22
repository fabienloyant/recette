package com.projet_recette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_recette.entities.UtilisateurRecette;

public interface UtilisateurRecetteRepository extends JpaRepository<UtilisateurRecette, Integer> {

}
