
interface IngredientInterface {
    id: number;
    nom: string;
    unite: Unite;
    typeIngredient: TypeIngredient;
}

enum Unite {
    ingredient = "ingrédient",
    ml = "ml",
    g = "g",
}

enum TypeIngredient {
    legume = "Légume",
    fruit = "Fruit",
    feculent = "Féculent",
    legumineuse = "Légumineuse",
    viande = "Viande",
    poisson = "Poisson",
    laitage = "Laitage",
    epice = "Epice",
    boisson = "Boisson",
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