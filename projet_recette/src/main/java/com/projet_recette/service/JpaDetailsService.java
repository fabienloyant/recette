package com.projet_recette.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projet_recette.entities.Utilisateur;
import com.projet_recette.model.SecurityUser;
import com.projet_recette.repository.UtilisateurRepository;


@Service
public class JpaDetailsService implements UserDetailsService {

	private UtilisateurRepository repo;
	
	public JpaDetailsService(UtilisateurRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Utilisateur user = repo.findByLogin(login);//méthode findbynameName 
		if(user != null) { 
			return new SecurityUser(user);
		} else {
			 throw new UsernameNotFoundException("identifiants incorrects");
		}	
	}	
}
