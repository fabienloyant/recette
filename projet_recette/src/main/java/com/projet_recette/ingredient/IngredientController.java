package com.projet_recette.ingredient;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/ingredient")
public class IngredientController {
	
	private final IngredientService ingredientService;
	
	public IngredientController(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}
	
	/************************************
	 * 	GET
	 *************************************/
	//findAll
	@GetMapping
	public List<Ingredient> findAll() {
		return ingredientService.findAll();
	}
	
	
	//findById
	@GetMapping("/{id}")
	public Ingredient findById(@PathVariable int id) {
		return ingredientService.findById(id);
	}
	
	
	//pour recherche personnalisée
	@GetMapping("/nom")
	public List<Ingredient> findByNom(@RequestParam String nom) {
		return ingredientService.findByNom(nom);
	}
	
	
	/************************************
	 * 	POST
	 *************************************/
	@PostMapping
	public Ingredient save(@RequestBody Ingredient ingredient) {
		return ingredientService.save(ingredient);
	}
	
	
	/************************************
	 * 	PUT
	 *************************************/
	@PutMapping
	public void update(@RequestBody Ingredient ingredient) {
		ingredientService.update(ingredient);
	}
	
	
	/************************************
	 * 	DELETE
	 *************************************/
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		ingredientService.deleteById(id);
	}

}
