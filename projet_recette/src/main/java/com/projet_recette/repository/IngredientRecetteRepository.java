package com.projet_recette.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_recette.entities.IngredientRecette;

public interface IngredientRecetteRepository extends JpaRepository<IngredientRecette, Integer>{
	
	public List<IngredientRecette> findByRecette(int id);

}
