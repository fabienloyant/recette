package com.projet_recette.utilisateur;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projet_recette.ingredient.Ingredient;
import com.projet_recette.ingredient.IngredientRepository;
import com.projet_recette.ingredient.IngredientService;
import com.projet_recette.recette.Recette;
import com.projet_recette.recette.RecetteService;

import lombok.Getter;
import lombok.Setter;

@Service
public class UtilisateurService {

	private final UtilisateurRepository utilisateurRepository;
	private final IngredientService ingredientService;
	private final RecetteService recetteService;
	
	public UtilisateurService(UtilisateurRepository utilisateurRepository, IngredientService ingredientService, RecetteService recetteService) {
		this.utilisateurRepository = utilisateurRepository;
		this.ingredientService = ingredientService;
		this.recetteService = recetteService;
	}
	
	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}
	
	public Utilisateur findById(int id) {
		return utilisateurRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));
	}
	
	public Utilisateur save(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
		return utilisateur;
	}
	
//	public Utilisateur addIngredient(int id, Ingredient ingredient) {
//		Utilisateur utilisateur = utilisateurRepository.findById(id)
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));
//		Ingredient ingredientSauvegarde = ingredientService.findOrInsertIngredient(ingredient);
//		utilisateur.getIngredient().add(ingredientSauvegarde);
//		utilisateurRepository.save(utilisateur);
//		return findById(id);
//	}
//	
//	public Utilisateur addRecette(int id, Recette recette) {
//		Utilisateur utilisateur = utilisateurRepository.findById(id)
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));
//		Recette recetteSauvegarde = recetteService.findOrInsertRecette(recette);
//		utilisateur.getRecette().add(recetteSauvegarde);
//		utilisateurRepository.save(utilisateur);
//		return findById(id);
//	}

	public Utilisateur update(Utilisateur utilisateur) {
		deleteById(utilisateur.getId());
		utilisateurRepository.save(utilisateur);
		return utilisateur;
	}
	
	public void deleteById(int id) {
		utilisateurRepository.deleteById(id);
	}

}
