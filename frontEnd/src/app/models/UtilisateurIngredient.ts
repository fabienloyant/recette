import { IngredientInterface } from "./IngredientModel";
import { UtilisateurInterface } from "./UtilisateurModel";

interface UtilisateurIngredient{
    id: number,
    quantite: number,
    utilisateur: UtilisateurInterface,
    ingredient: IngredientInterface
}

class urModel implements UtilisateurIngredient{
    id!: number;
    quantite!: number;
    utilisateur!: UtilisateurInterface;
    ingredient!: IngredientInterface;

    constructor(quantite?: number,utilisateur?: UtilisateurInterface,
        ingredient?: IngredientInterface){
            if (quantite) this.quantite = quantite;
            if (utilisateur) this.utilisateur = utilisateur
            if (ingredient) this.ingredient = ingredient
        }
}

export{UtilisateurIngredient}