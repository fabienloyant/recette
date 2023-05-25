
interface IngredientInterface {
    id: number;
    nom: string;
    unite: Unite;
    typeIngredient: TypeIngredient;
}

enum Unite {
    INGREDIENT ="Ingrédient",
    ML = "Millilitre",
    G ="Gramme",
}

enum TypeIngredient {

    LEGUME ="Légume", 
    FRUIT ="Fruit",
    FECULENT = "Féculent",
    LEGUMINEUSE="Légumineuse",
    VIANDE = "Viande",
    POISSON = "Poisson",
    LAITAGE = "Laitage",
    EPICE = "Epice",
    BOISSON = "Boisson",
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