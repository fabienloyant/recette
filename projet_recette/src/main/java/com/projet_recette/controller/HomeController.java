/*

package com.projet_recette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recettefinder")
@CrossOrigin // gère les problèmes de CORS
public class HomeController {
	
	@GetMapping()
	@PreAuthorize("hasRole('ROLE_USER')") // donne accès à la route pour les ROLES_USER
	public String user() {
		return "Hello user";
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')") // donne accès à la route pour les ROLE_ADMIN
	public String admin() {
		return "Hello admin";
	}
}

*/