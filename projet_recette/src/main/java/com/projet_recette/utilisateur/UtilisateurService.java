package com.projet_recette.utilisateur;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class UtilisateurService {

	private UtilisateurRepository utilisateurRepository;
	
	public UtilisateurService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}
	
	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}
	
	public Utilisateur findById(int id) {
		return utilisateurRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));
	}
	
	public Utilisateur save(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
		return utilisateur;
	}
	
	public Utilisateur update(Utilisateur utilisateur) {
		deleteById(utilisateur.getId());
		utilisateurRepository.save(utilisateur);
		return utilisateur;
	}
	
	public void deleteById(int id) {
		utilisateurRepository.deleteById(id);
	}

}
