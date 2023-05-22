package com.projet_recette.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projet_recette.entities.UtilisateurRecette;
import com.projet_recette.repository.UtilisateurRecetteRepository;

@Service
public class UtilisateurRecetteService {
	
	private final UtilisateurRecetteRepository utilisateurRecetteRepository;
	
	public UtilisateurRecetteService(UtilisateurRecetteRepository utilisateurRecetteRepository) {
		this.utilisateurRecetteRepository = utilisateurRecetteRepository;
	}
	
	public List<UtilisateurRecette>findAll(){
		return utilisateurRecetteRepository.findAll();
	}
	
	
	public UtilisateurRecette findById(int id) {
		return utilisateurRecetteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UtilisateurRecette non trouvé"));
	}
	
	
	public UtilisateurRecette save(UtilisateurRecette utilisateurRecette) {
		return utilisateurRecetteRepository.save(utilisateurRecette);
	}
	
	
	public void deleteById(int id) {
		utilisateurRecetteRepository.deleteById(id);
	}
	
	
	public void deleteAll() {
		utilisateurRecetteRepository.deleteAll();
	}
	

	public UtilisateurRecette update(UtilisateurRecette utilisateurRecette) {
		deleteById(utilisateurRecette.getId());
		utilisateurRecetteRepository.save(utilisateurRecette);
		return utilisateurRecette;
	}
}
