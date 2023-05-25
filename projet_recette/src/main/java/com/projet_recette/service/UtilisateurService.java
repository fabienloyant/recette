package com.projet_recette.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.projet_recette.dto.ingredient.IngredientCompletDto;
import com.projet_recette.dto.ingredient.IngredientReduitDto;
import com.projet_recette.dto.recette.RecetteReduitDto;
import com.projet_recette.dto.utilisateur.UtilisateurCompletDto;
import com.projet_recette.dto.utilisateur.UtilisateurReduitDto;
import com.projet_recette.entities.Ingredient;
import com.projet_recette.entities.Recette;
import com.projet_recette.entities.Utilisateur;
import com.projet_recette.entities.UtilisateurIngredient;
import com.projet_recette.entities.UtilisateurRecette;
import com.projet_recette.repository.IngredientRepository;
import com.projet_recette.repository.UtilisateurRepository;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtilisateurService {

	private final UtilisateurRepository utilisateurRepository;
	private final IngredientService ingredientService;
	private final RecetteService recetteService;
	private final UtilisateurIngredientService utilisateurIngredientService;
	private final ObjectMapper objectMapper;
	private final UtilisateurRecetteService utilisateurRecetteService ;
	
	
	
	public UtilisateurService(UtilisateurRepository utilisateurRepository, IngredientService ingredientService, RecetteService recetteService, UtilisateurIngredientService utilisateurIngredientService, UtilisateurRecetteService utilisateurRecetteService ) {
		this.utilisateurRepository = utilisateurRepository;
		this.ingredientService = ingredientService;
		this.recetteService = recetteService;
		this.utilisateurIngredientService = utilisateurIngredientService;
		this.utilisateurRecetteService = utilisateurRecetteService ;
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
		List<IngredientReduitDto> ingredientReduitList = utilisateurIngredientList.stream().map(utilisateurIngredient -> toDto(utilisateurIngredient)).toList();
		utilisateurComplet.setIngredients(ingredientReduitList);
		
		List <UtilisateurRecette> utilisateurRecetteList = utilisateurRecetteService.findByUtilisateur(id);
		List<RecetteReduitDto> recetteReduitList = utilisateurRecetteList.stream().map(utilisateurRecette -> toDtoRecette(utilisateurRecette)).toList();		
		utilisateurComplet.setRecettes(recetteReduitList);
		
		
		/*Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));
        UtilisateurCompletDto utilisateurComplet = objectMapper.convertValue(utilisateur, UtilisateurCompletDto.class);
        List<UtilisateurIngredient> utilisateurIngredientList = utilisateurIngredientService.findByUtilisateurId(id);
        List<IngredientReduitDto> ingredientReduitList = utilisateurIngredientList.stream().map(utilisateurIngredient -> objectMapper.convertValue(utilisateurIngredient.getIngredient(), IngredientReduitDto.class)).toList();
        ingredientReduitList.forEach(ingredient -> ingredient.getQuantite());
        utilisateurComplet.setIngredients(ingredientReduitList);
        */
		
		return utilisateurComplet;
	}
	
	/*
	 * Méthode pour mettre les valeurs des attributs à partir de la table utilisateuringredient de utilisateurComplet
	 */
	public IngredientReduitDto toDto(UtilisateurIngredient user) {
		IngredientReduitDto reduit = new IngredientReduitDto();
		reduit.setId(user.getIngredient().getId());
		reduit.setNom(user.getIngredient().getNom());
		reduit.setUnite(user.getIngredient().getUnite());
		reduit.setTypeIngredient(user.getIngredient().getTypeIngredient());
		reduit.setQuantite(user.getQuantite());
		
		return reduit;
	}
	
	/*
	 * Méthode pour attribuer les valeurs des attribut de utilisateur ingredient dans untilisateur complet
	 */
	public RecetteReduitDto toDtoRecette(UtilisateurRecette data) {
		RecetteReduitDto reduit = new RecetteReduitDto();
		
		reduit.setIdRecette(data.getRecette().getIdRecette());
		reduit.setNom(data.getRecette().getNomRecette());
		reduit.setNbPersonnes(data.getRecette().getNbPersonnes());
		reduit.setConsignes(data.getRecette().getConsignes());
		reduit.setTempsPreparation(data.getRecette().getTempsPreparation());
		reduit.setTempsCuisson(data.getRecette().getTempsCuisson());
		reduit.setTempsRepos(data.getRecette().getTempsRepos());
		reduit.setDateAjout(data.getRecette().getDateAjout());
		reduit.setLastUpdate(data.getRecette().getLastUpdate());
		
		return reduit;
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
