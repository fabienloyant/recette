package com.projet_recette.recette;

import java.util.List;

import org.springframework.stereotype.Service;

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
		return recetteRepository.findById(id).orElse(null);
	}
	
	public Recette save(Recette recette) {
		recetteRepository.save(recette);
		return recette;
	}
	
	public void deleteById(int id) {
		recetteRepository.deleteById(id);
	}
	
	public void update(Recette recette) {
		 deleteById(recette.getId());
		 recetteRepository.save(recette);
	}
}
