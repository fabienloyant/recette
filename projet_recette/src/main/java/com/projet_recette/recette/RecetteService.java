package com.projet_recette.recette;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projet_recette.ingredient.Ingredient;
import com.projet_recette.ingredient.IngredientService;

@Service
public class RecetteService {
	private final RecetteRepository recetteRepository;
	
	private final IngredientService ingredientService;
	
	public RecetteService(RecetteRepository recetteRepository, IngredientService ingredientService) {
		this.recetteRepository = recetteRepository;
		this.ingredientService = ingredientService;
	}
	
	public List<Recette> findAll(){
		return recetteRepository.findAll();
	}
	
	public Recette findById(int id) {
		return recetteRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recette non trouvée")); 
	}
	
	public Recette save(Recette recette) {
		recetteRepository.save(recette);
		return recette;
	}
	
	public void deleteById(int id) {
		recetteRepository.deleteById(id);
	}
	
	public void update(Recette recette) {
		 deleteById(recette.getIdRecette());
		 recetteRepository.save(recette);
	}
	
	public Recette findOrInsertRecette(Recette recette) {
		return recetteRepository.findById(recette.getIdRecette()).orElseGet(() -> recetteRepository.save(recette));
	}
	
//	public Recette addIngredient(Integer id , Ingredient ingredient) {
//		Recette recette = recetteRepository.findById(id)
//							.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recette non trouvée") );
//		Ingredient ingredientSauvegarde = ingredientService.findOrInsertIngredient(ingredient);
//		recette.getIngredient().add(ingredientSauvegarde);
//		recetteRepository.save(recette);
//		return findById(id);
//	}
}
