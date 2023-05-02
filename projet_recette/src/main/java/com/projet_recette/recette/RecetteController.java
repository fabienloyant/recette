package com.projet_recette.recette;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RecetteController {
	private final RecetteService recetteService;
	
	public RecetteController(RecetteService recetteService) {
		this.recetteService = recetteService;
	}
	
	@GetMapping
	public List<Recette> findAll(){
		return recetteService.findAll();
	}
	
	@GetMapping ("/{id}")
	public Recette findById(@PathVariable int  id) {
		return recetteService.findById(id);
	}
	
	@PostMapping
	public void  save(@RequestBody Recette recette) {
		recetteService.save(recette);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		recetteService.deleteById(id);
	}
	
	@PatchMapping("{id}")
	public void update(@RequestBody Recette recette) {
		recetteService.update(recette);
	}
}
