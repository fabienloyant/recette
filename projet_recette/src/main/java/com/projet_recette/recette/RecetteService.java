package com.projet_recette.recette;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RecetteService {
	private final RecetteRepository recetteRepository;
	
	public RecetteService(RecetteRepository recetteRepository) {
		this.recetteRepository = recetteRepository;
	}
	
	public List<Recette> findAll(){
		return recetteRepository.findAll();
	}
	
	public Recette findById(int id) {
		return recetteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recette non trouvée")); 
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
}
