interface RecetteInterface {
    id: number,
    nom: string,
    tempsPreparation: number,
    tempsCuisson: number,
    tempsRepos: number,
    nombrePersonnes: number,
    consignes: string,
    dateAjout: Date,
    lastUpdate: Date
}

class RecetteModel implements RecetteInterface {
    id!: number;
    nom!: string;
    tempsPreparation!: number;
    tempsCuisson!: number;
    tempsRepos!: number;
    nombrePersonnes!: number;
    consignes!: string;
    dateAjout!: Date;
    lastUpdate!: Date;

    constructor(
        id?: number,
        nom?: string,
        tempsPreparation?: number,
        tempsCuisson?: number,
        tempsRepos?: number,
        nombrePersonnes?: number,
        consignes?: string,
        dateAjout?: Date,
        lastUpdate?: Date) {
            if (id) this.id = id;
            if (nom) this.nom = nom;
            if (tempsPreparation) this.tempsPreparation = tempsPreparation;
            if (tempsCuisson) this.tempsCuisson = tempsCuisson;
            if (tempsRepos) this.tempsRepos = tempsRepos;
            if (nombrePersonnes) this.nombrePersonnes = nombrePersonnes;
            if (consignes) this.consignes = consignes;
            if (dateAjout) this.dateAjout = dateAjout;
            if (lastUpdate) this.lastUpdate = lastUpdate;
    }

    toString = () => {
        return (`
            id : ${this.id},
            name : ${this.nom},
            tempsPreparation : ${this.tempsPreparation},
            tempsCuisson : ${this.tempsCuisson},
            tempsRepos : ${this.tempsRepos},
            nombrePersonnes : ${this.nombrePersonnes},
            consignes : ${this.consignes},
            dateAjout : ${this.dateAjout},
            lastUpdate : ${this.lastUpdate}
            `)
    }

}

export {RecetteInterface, RecetteModel}