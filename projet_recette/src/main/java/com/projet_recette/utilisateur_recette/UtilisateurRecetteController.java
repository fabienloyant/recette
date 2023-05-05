package com.projet_recette.utilisateur_recette;

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

@RestController
@RequestMapping("userrecip")
@CrossOrigin
public class UtilisateurRecetteController {
	
	private final UtilisateurRecetteService utilisateurRecetteService;
	
	public UtilisateurRecetteController(UtilisateurRecetteService utilisateurRecetteService){
		this.utilisateurRecetteService = utilisateurRecetteService;
	}
	
	@GetMapping
	public  List<UtilisateurRecette>findAll(){
		return utilisateurRecetteService.findAll();
	}
	
	@GetMapping("/{id}")
	public UtilisateurRecette findById(@PathVariable int id) {
		return utilisateurRecetteService.findById(id);
		
	}
	@PostMapping
	public UtilisateurRecette save(UtilisateurRecette utilisateurRecette) {
		return utilisateurRecetteService.save(utilisateurRecette);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		utilisateurRecetteService.findById(id);
	}
	@DeleteMapping
	public void deleteAll() {
		utilisateurRecetteService.deleteAll();
	}
	
	@PutMapping
	public void update(@RequestBody UtilisateurRecette utilisateurRecette) {
		utilisateurRecetteService.update(utilisateurRecette);
	}
}
