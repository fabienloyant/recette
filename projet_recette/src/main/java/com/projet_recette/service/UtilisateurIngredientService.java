package com.projet_recette.service;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projet_recette.entities.Ingredient;
import com.projet_recette.entities.Recette;
import com.projet_recette.entities.Utilisateur;
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
	
	public List<UtilisateurIngredient> findByUtilisateurId(int id) {
		return utilisateurIngredientRepository.findByUtilisateurId(id);
	}
	
	public UtilisateurIngredient findById(int id) {
		return utilisateurIngredientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));
	}
	
	public UtilisateurIngredient save(UtilisateurIngredient utilisateurIngredient) {
		utilisateurIngredientRepository.save(utilisateurIngredient);
		return utilisateurIngredient;
	}

	public UtilisateurIngredient update(int id ,UtilisateurIngredient utilisateurIngredient) {
		UtilisateurIngredient uiFromBD = this.findById(id);
		uiFromBD.setId(utilisateurIngredient.getId());
		uiFromBD.setQuantite(utilisateurIngredient.getQuantite());
		uiFromBD.setIngredient(utilisateurIngredient.getIngredient());
		uiFromBD.setUtilisateur(utilisateurIngredient.getUtilisateur());
		
		return uiFromBD;
	}
	
	public void deleteById(int id) {
		utilisateurIngredientRepository.deleteById(id);
	}

}
