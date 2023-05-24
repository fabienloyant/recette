package com.projet_recette.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.projet_recette.dto.ingredient.IngredientReduitDto;
import com.projet_recette.dto.utilisateur.UtilisateurCompletDto;
import com.projet_recette.entities.Ingredient;
import com.projet_recette.entities.Recette;
import com.projet_recette.entities.Utilisateur;
import com.projet_recette.entities.UtilisateurIngredient;
import com.projet_recette.repository.IngredientRepository;
import com.projet_recette.repository.UtilisateurRepository;

import lombok.Getter;
import lombok.Setter;

@Service
public class UtilisateurService {

	private final UtilisateurRepository utilisateurRepository;
	private final IngredientService ingredientService;
	private final RecetteService recetteService;
	private final UtilisateurIngredientService utilisateurIngredientService;
	private final ObjectMapper objectMapper;
	
	
	
	public UtilisateurService(UtilisateurRepository utilisateurRepository, IngredientService ingredientService, RecetteService recetteService, UtilisateurIngredientService utilisateurIngredientService) {
		this.utilisateurRepository = utilisateurRepository;
		this.ingredientService = ingredientService;
		this.recetteService = recetteService;
		this.utilisateurIngredientService = utilisateurIngredientService;
		this.objectMapper = new ObjectMapper();
//		this.objectMapper.registerModule(new Jdk8Module());
//		this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.registerModule(new JavaTimeModule());
		
	}
	
	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}
	
	public Utilisateur findById(int id) {
		return utilisateurRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));
	}
	
	public UtilisateurCompletDto findByIdWithIngredients(int id) {
		
		
		
		Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));
		UtilisateurCompletDto utilisateurComplet = objectMapper.convertValue(utilisateur, UtilisateurCompletDto.class);
		List<UtilisateurIngredient> utilisateurIngredientList = utilisateurIngredientService.findByUtilisateurId(id);
		List<IngredientReduitDto> ingredientReduitList = utilisateurIngredientList.stream().map(utilisateurIngredient -> objectMapper.convertValue(utilisateurIngredient.getIngredient(), IngredientReduitDto.class)).toList();
		
		//ingredientReduitList.forEach(ingredient -> utilisateurIngredientList.stream().filter(ingredient.getId() -> Objects.equals() ));
		
//		ingredientReduitList.forEach(ingredient -> ingredient.setQuantite(
//				return utilisateurIngredientList.forEach(ing -> ing.getQuantite())));	
		
		utilisateurComplet.setIngredients(ingredientReduitList);
		
		return utilisateurComplet;
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

	public Utilisateur update(int id ,Utilisateur utilisateur) {
		
		Utilisateur utilisateurFromDB = this.findById(id);
		utilisateurFromDB.setPrenom(utilisateur.getPrenom());
		utilisateurFromDB.setNom(utilisateur.getNom());
		utilisateurFromDB.setLogin(utilisateur.getLogin());
		utilisateurFromDB.setDateDeNaissance(utilisateur.getDateDeNaissance());
		
		return utilisateurRepository.save(utilisateurFromDB);
	}
	
	public void deleteById(int id) {
		utilisateurRepository.deleteById(id);
	}

}
