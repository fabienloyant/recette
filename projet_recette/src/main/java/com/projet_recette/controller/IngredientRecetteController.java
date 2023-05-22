package com.projet_recette.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet_recette.entities.Ingredient;
import com.projet_recette.entities.IngredientRecette;
import com.projet_recette.service.IngredientRecetteService;

@RestController
@CrossOrigin
@RequestMapping("/ingredientrecette")
public class IngredientRecetteController {
	
	private final IngredientRecetteService ingredientRecetteService;

	public IngredientRecetteController(IngredientRecetteService ingredientRecetteService) {
		this.ingredientRecetteService = ingredientRecetteService;
	}
	
	
	/************************************
	 * 	GET
	 *************************************/
	//findAll
	@GetMapping
	public List<IngredientRecette> findAll() {
		return ingredientRecetteService.findAll();
	}

	//findById
	@GetMapping("/{id}")
	public IngredientRecette findById(@PathVariable int id) {
		return ingredientRecetteService.findById(id);
	}
	
	
	/************************************
	 * 	POST
	 *************************************/
	@PostMapping
	public IngredientRecette save(@RequestBody IngredientRecette ingredientRecette) {
		return ingredientRecetteService.save(ingredientRecette);
	}
	
	
	/************************************
	 * 	PUT
	 *************************************/
	@PutMapping
	public void update(@RequestBody IngredientRecette ingredientRecette) {
		ingredientRecetteService.update(ingredientRecette);
	}
	
	
	/************************************
	 * 	DELETE
	 *************************************/
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		ingredientRecetteService.deleteById(id);
	}
}
