package com.projet_recette.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projet_recette.dto.ingredient.IngredientCompletDto;
import com.projet_recette.dto.ingredient.IngredientSansRecetteDto;
import com.projet_recette.dto.recette.RecetteCompletDto;
import com.projet_recette.dto.utilisateur.UtilisateurCompletDto;
import com.projet_recette.dto.utilisateur.UtilisateurSansRecetteDto;
import com.projet_recette.entities.IngredientRecette;
import com.projet_recette.entities.Recette;
import com.projet_recette.entities.UtilisateurRecette;
import com.projet_recette.repository.RecetteRepository;

@Service
public class RecetteService {
	private final RecetteRepository recetteRepository;
	
	private final ObjectMapper objectMapper;
	
	private final IngredientRecetteService service;
	
	private final UtilisateurRecetteService utilisateurRecetteService;
	
	
	public RecetteService(RecetteRepository recetteRepository, ObjectMapper objectMapper,IngredientRecetteService service, UtilisateurRecetteService utilisateurRecetteService) {
		this.recetteRepository = recetteRepository;
		this.objectMapper = objectMapper;
		this.service = service;
		this.utilisateurRecetteService = utilisateurRecetteService;
	}
	
	public List<Recette> findAll(){
		return recetteRepository.findAll();
	}
	
	public Recette findById(int id) {
		return recetteRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recette non trouvée")); 
	}
	
	public RecetteCompletDto ListIngredient(int id) {
		Recette recette = recetteRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recette non trouvée"));
		
		RecetteCompletDto recComplet= objectMapper.convertValue(recette, RecetteCompletDto.class);
		
		List<IngredientRecette> ingredientRecetteList = service.findByRecette(id);
		List<IngredientSansRecetteDto> ingredientSansRecetteList = ingredientRecetteList.stream().map(ingredientRecette -> toDto(ingredientRecette)).toList();
		recComplet.setIngredient(ingredientSansRecetteList);
			
			
		List<UtilisateurRecette> utilisateurRecetteList = utilisateurRecetteService.findByUtilisateur(id);
		List<UtilisateurSansRecetteDto> usrList = utilisateurRecetteList.stream().map(utilisateurRecette -> toDtoUtilisateur(utilisateurRecette)).toList();	
		recComplet.setUtilisateur(usrList);	
		
		return recComplet;
	}
	
	public IngredientSansRecetteDto toDto(IngredientRecette data) {
		IngredientSansRecetteDto norecette = new IngredientSansRecetteDto();
		
		norecette.setId(data.getIngredient().getId());
		norecette.setNom(data.getIngredient().getNom());
		norecette.setTypeIngredient(data.getIngredient().getTypeIngredient());
		norecette.setUnite(data.getIngredient().getUnite());
		norecette.setQuantite(data.getQuantite());
		return norecette;
	}
	
	public UtilisateurSansRecetteDto toDtoUtilisateur(UtilisateurRecette data) {
		
		UtilisateurSansRecetteDto rd = new UtilisateurSansRecetteDto();
		
		rd.setId(data.getUtilisateur().getId());
		rd.setNom(data.getUtilisateur().getNom());
		rd.setPrenom(data.getUtilisateur().getPrenom());
		
		
		return rd;
		
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
