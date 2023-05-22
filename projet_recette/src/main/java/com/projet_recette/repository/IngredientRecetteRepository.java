package com.projet_recette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_recette.entities.IngredientRecette;

public interface IngredientRecetteRepository extends JpaRepository<IngredientRecette, Integer>{

}
