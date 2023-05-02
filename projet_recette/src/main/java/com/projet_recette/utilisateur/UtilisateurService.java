package com.projet_recette.utilisateur;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
	
	public Optional<Utilisateur> findById(int id) {
		return utilisateurRepository.findById(id);
	}
	
	public void save(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
	}
	
	public void update(int id, Utilisateur utilisateur) {
		utilisateurRepository.deleteById(id);
		utilisateurRepository.save(utilisateur);
	}
	
	public void deleteById(int id) {
		utilisateurRepository.deleteById(id);
	}
	
	public void deleteAll() {
		utilisateurRepository.deleteAll();
	}
	
}
