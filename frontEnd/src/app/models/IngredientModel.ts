
interface IngredientInterface {
    id: number;
    nom: string;
    unite: Unite;
    typeIngredient: TypeIngredient;
}

enum Unite {
    INGREDIENT = "INGREDIENT",
    ML = "ML" ,
    G  = "G",
}

enum TypeIngredient {

    LEGUME = "LEGUME", 
    FRUIT = "FRUIT",
    FECULENT = "FECULENT",
    LEGUMINEUSE = "LEGUMINEUSE",
    VIANDE = "VIANDE",
    POISSON = "POISSON",
    LAITAGE = "LAITAGE",
    EPICE = " EPICE",
    BOISSON = "BOISSON",
}

class IngredientModel implements IngredientInterface {

    id!: number;
    nom!: string;
    unite!: Unite;
    typeIngredient!: TypeIngredient;

    constructor(nom?: string, unite?: Unite, typeIngredient?: TypeIngredient) {
        if(nom) this.nom = nom;
        if(unite) this.unite = unite;
        if(typeIngredient) this.typeIngredient = typeIngredient;
    }
}

export {IngredientInterface, IngredientModel, Unite, TypeIngredient}