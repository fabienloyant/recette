package com.projet_recette.utilisateur;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

	private final UtilisateurService utilisateurService;

	public UtilisateurController(UtilisateurService utilisateurService) {
		super();
		this.utilisateurService = utilisateurService;
	}
	
	@GetMapping("/findall")
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}
	
	@GetMapping("/findbyid")
	public Optional<Utilisateur> findById(@RequestParam int id) {
		return utilisateurService.findById(id);
	}
	
	@PostMapping("/save")
	public void save(@RequestBody Utilisateur utilisateur) {
		utilisateurService.save(utilisateur);
	}
	
	@PutMapping("/update")
	public void update(@RequestParam int id, @RequestBody Utilisateur utilisateur) {
		utilisateurService.update(id, utilisateur);
	}
	
	@DeleteMapping("/deletebyid")
	public void deleteById(@RequestParam int id) {
		utilisateurService.deleteById(id);
	}
	
	@DeleteMapping("/deleteall")
	public void deleteAll() {
		utilisateurService.deleteAll();
	}
	
}
