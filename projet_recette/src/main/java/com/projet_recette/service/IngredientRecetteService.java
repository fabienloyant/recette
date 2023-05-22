package com.projet_recette.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projet_recette.entities.IngredientRecette;
import com.projet_recette.repository.IngredientRecetteRepository;

@Service
public class IngredientRecetteService {
	
	private final IngredientRecetteRepository ingredientRecetteRepository;

	public IngredientRecetteService(IngredientRecetteRepository ingredientRecetteRepository) {
		this.ingredientRecetteRepository = ingredientRecetteRepository;
	}
	
	
	//findAll
	public List<IngredientRecette> findAll() {
		return ingredientRecetteRepository.findAll();
	}
	
	//findById
	public IngredientRecette findById(int id) {
		return ingredientRecetteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient-Recette non trouvé")); //renvoie un message personnalisé de l'erreur
	}
	
	//save = create
	public IngredientRecette save(IngredientRecette ingredientRecette) {
		ingredientRecetteRepository.save(ingredientRecette);
		return ingredientRecette;
	}
	
	//deleteById
	public void deleteById(int id) {
		ingredientRecetteRepository.deleteById(id);
	}
	
	//update
	public void update(IngredientRecette ingredientRecette) {
		deleteById(ingredientRecette.getId());
		ingredientRecetteRepository.save(ingredientRecette);
	}
	
}
