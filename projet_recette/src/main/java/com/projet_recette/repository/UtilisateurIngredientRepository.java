package com.projet_recette.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_recette.entities.Ingredient;
import com.projet_recette.entities.UtilisateurIngredient;

public interface UtilisateurIngredientRepository extends JpaRepository<UtilisateurIngredient, Integer> {
	List<UtilisateurIngredient> findByUtilisateurId(int utilisateur_id);
}