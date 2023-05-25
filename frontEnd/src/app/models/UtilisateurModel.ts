interface UtilisateurInterface {
    id: number, 
    prenom: string,
    nom: string,
    dateDeNaissance: Date;
    login: string;
    mdp: string
}

class UtilisateurModel implements UtilisateurInterface {

    id!: number; 
    prenom!: string;
    nom!: string;
    dateDeNaissance!: Date;
    login!: string;
    mdp!: string

    constructor(prenom?: string, nom?: string, dateDeNaissance?: Date, login?: string, mdp?: string) {
        if (prenom) this.prenom = prenom;
        if (nom) this.nom = nom;
        if (dateDeNaissance) this.dateDeNaissance = dateDeNaissance;
        if (login) this.login = login;
        if (mdp) this.mdp = mdp;
    }

}

export {UtilisateurInterface, UtilisateurModel}