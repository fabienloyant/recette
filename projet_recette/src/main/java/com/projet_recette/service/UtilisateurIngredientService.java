package com.projet_recette.service;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projet_recette.entities.Ingredient;
import com.projet_recette.entities.Recette;
import com.projet_recette.entities.UtilisateurIngredient;
import com.projet_recette.repository.IngredientRepository;
import com.projet_recette.repository.UtilisateurIngredientRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class UtilisateurIngredientService {

	private final UtilisateurIngredientRepository utilisateurIngredientRepository;
	
	public UtilisateurIngredientService(UtilisateurIngredientRepository utilisateurIngredientRepository) {
		this.utilisateurIngredientRepository = utilisateurIngredientRepository;
	}
	
	public List<UtilisateurIngredient> findAll() {
		return utilisateurIngredientRepository.findAll();
	}
	
	public UtilisateurIngredient findById(int id) {
		return utilisateurIngredientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));
	}
	
	public UtilisateurIngredient save(UtilisateurIngredient utilisateurIngredient) {
		utilisateurIngredientRepository.save(utilisateurIngredient);
		return utilisateurIngredient;
	}

	public UtilisateurIngredient update(UtilisateurIngredient utilisateurIngredient) {
		deleteById(utilisateurIngredient.getId());
		utilisateurIngredientRepository.save(utilisateurIngredient);
		return utilisateurIngredient;
	}
	
	public void deleteById(int id) {
		utilisateurIngredientRepository.deleteById(id);
	}

}
