package com.projet_recette.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class IngredientRecette {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne
	@JoinColumn(name = "ingredient_id")
	private Ingredient ingredient;
	
	@ManyToOne
	@JoinColumn(name = "recette_id")
	private Recette recette;
	
	private Double quantite;

	public IngredientRecette(int id, Ingredient ingredient, Recette recette, Double quantite) {
		this.id = id;
		this.ingredient = ingredient;
		this.recette = recette;
		this.quantite = quantite;
	}

}
