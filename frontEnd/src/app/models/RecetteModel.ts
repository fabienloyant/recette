interface RecetteInterface {
    idRecette: number,
    nomRecette: string,
    tempsPreparation: number,
    tempsCuisson: number,
    tempsRepos: number,
    nbPersonnes: number,
    consignes: string,
    dateAjout: Date,
    lastUpdate: Date
}

class RecetteModel implements RecetteInterface {
    idRecette!: number;
    nomRecette!: string;
    tempsPreparation!: number;
    tempsCuisson!: number;
    tempsRepos!: number;
    nbPersonnes!: number;
    consignes!: string;
    dateAjout!: Date;
    lastUpdate!: Date;

    constructor(
        idRecette?: number,
        nomRecette?: string,
        tempsPreparation?: number,
        tempsCuisson?: number,
        tempsRepos?: number,
        nbPersonnes?: number,
        consignes?: string,
        dateAjout?: Date,
        lastUpdate?: Date) {
            if (idRecette) this.idRecette = idRecette;
            if (nomRecette) this.nomRecette = nomRecette;
            if (tempsPreparation) this.tempsPreparation = tempsPreparation;
            if (tempsCuisson) this.tempsCuisson = tempsCuisson;
            if (tempsRepos) this.tempsRepos = tempsRepos;
            if (nbPersonnes) this.nbPersonnes = nbPersonnes;
            if (consignes) this.consignes = consignes;
            if (dateAjout) this.dateAjout = dateAjout;
            if (lastUpdate) this.lastUpdate = lastUpdate;
    }

    toString = () => {
        return (`
            id : ${this.idRecette},
            name : ${this.nomRecette},
            tempsPreparation : ${this.tempsPreparation},
            tempsCuisson : ${this.tempsCuisson},
            tempsRepos : ${this.tempsRepos},
            nomRecettebrePersonnes : ${this.nbPersonnes},
            consignes : ${this.consignes},
            dateAjout : ${this.dateAjout},
            lastUpdate : ${this.lastUpdate}
            `)
    }

}

export {RecetteInterface, RecetteModel}