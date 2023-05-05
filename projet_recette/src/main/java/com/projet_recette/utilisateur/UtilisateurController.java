package com.projet_recette.utilisateur;

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
@RequestMapping("/utilisateur")
public class UtilisateurController {

	private final UtilisateurService utilisateurService;

	public UtilisateurController(UtilisateurService utilisateurService) {
		super();
		this.utilisateurService = utilisateurService;
	}
	
	@GetMapping
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}
	
	@GetMapping("/{id}")
	public Utilisateur findById(@PathVariable int id) {
		return utilisateurService.findById(id);
	}
	
	@PostMapping
	public Utilisateur save(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.save(utilisateur);
	}
	
	@PutMapping
	public void update(@RequestBody Utilisateur utilisateur) {
		utilisateurService.update(utilisateur);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		utilisateurService.deleteById(id);
	}
	
}
