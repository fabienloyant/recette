package com.projet_recette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_recette.entities.Recette;

public interface RecetteRepository extends JpaRepository<Recette, Integer> {

}
