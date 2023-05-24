package com.projet_recette.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projet_recette.entities.Ingredient;
import com.projet_recette.entities.Recette;
import com.projet_recette.repository.RecetteRepository;

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
	
	public Recette update( int id,Recette recette) {
		 Recette recetteFromDB= this.findById(id);
		 
		 recetteFromDB.setNomRecette(recette.getNomRecette());
		 recetteFromDB.setTempsPreparation(recette.getTempsPreparation());
		 recetteFromDB.setTempsCuisson(recette.getTempsCuisson());
		 recetteFromDB.setTempsRepos(recette.getTempsRepos());
		 recetteFromDB.setNbPersonnes(recette.getNbPersonnes());
		 recetteFromDB.setConsignes(recette.getConsignes());
		 recetteFromDB.setLastUpdate(recette.getLastUpdate());
		
		 return recetteRepository.save(recetteFromDB);
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
