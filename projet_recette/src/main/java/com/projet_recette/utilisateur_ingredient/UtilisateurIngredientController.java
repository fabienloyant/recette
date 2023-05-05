package com.projet_recette.utilisateur_ingredient;

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
@RequestMapping("/utilisateuringredient")
public class UtilisateurIngredientController {

	private final UtilisateurIngredientService utilisateurIngredientService;

	public UtilisateurIngredientController(UtilisateurIngredientService utilisateurIngredientService) {
		super();
		this.utilisateurIngredientService = utilisateurIngredientService;
	}
	
	@GetMapping
	public List<UtilisateurIngredient> findAll() {
		return utilisateurIngredientService.findAll();
	}
	
	@GetMapping("/{id}")
	public UtilisateurIngredient findById(@PathVariable int id) {
		return utilisateurIngredientService.findById(id);
	}
	
	@PostMapping
	public UtilisateurIngredient save(@RequestBody UtilisateurIngredient utilisateurIngredient) {
		return utilisateurIngredientService.save(utilisateurIngredient);
	}
	
	@PutMapping
	public void update(@RequestBody UtilisateurIngredient utilisateurIngredient) {
		utilisateurIngredientService.update(utilisateurIngredient);
	}
	
	@DeleteMapping("/deletebyid")
	public void deleteById(@RequestParam int id) {
		utilisateurIngredientService.deleteById(id);
	}
	
}
