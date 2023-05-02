package com.projet_recette.ingredient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{
	
	//recherche personnalisée par nom
	List<Ingredient> findByNom(String nom);
}
