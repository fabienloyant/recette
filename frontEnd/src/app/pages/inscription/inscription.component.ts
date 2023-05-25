import { Component } from '@angular/core';
import { UtilisateurInterface } from 'src/app/models/UtilisateurModel';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent {

  utilisateurs: UtilisateurInterface[] = []

  constructor(private service: UtilisateurService) {}

  addUtilisateurs = (data: UtilisateurInterface) => {
    this.service.addUtilisateur(data).subscribe(
      {
        next: (data: UtilisateurInterface) => {
          this.utilisateurs.push(data)
          console.log(data);
          console.log("addutilisateur");
          
        },
        error: (err) => {
          console.log(err);
        }
      })
  }

  //méthode patchmdp a faire

}
