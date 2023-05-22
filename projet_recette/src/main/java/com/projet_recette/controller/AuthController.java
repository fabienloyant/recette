/*

package com.projet_recette.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet_recette.entities.Utilisateur;
import com.projet_recette.service.TokenService;
import com.projet_recette.service.UtilisateurService;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	

	// controller permettant la connection à notre api
	
	private final UtilisateurService service;
	private final TokenService token;
	
	public AuthController(UtilisateurService service, TokenService token) {
		this.service = service;
		this.token = token;
	}
	
	/**
	 * 
	 * @return
	 
	@PostMapping("/login")
	public String login(Authentication authentication) {
		return token.generateToken(authentication);
	}
	
	@PostMapping("/new")
	public Utilisateur create(@RequestBody Utilisateur user) {
		return service.save(user);
	}
	
}

*/