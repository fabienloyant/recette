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

  ngOnInit() {
    this.getUtilisateur()
  }

  getUtilisateur = () => {
    this.service.getUtilisateurs().subscribe(
      {
        next: (data: UtilisateurInterface[]) => {
          this.utilisateurs = data;
        },
        error: (err) => {
          console.error(err);
        },
        complete: () => {
          console.log("complete");
        }
      })
  }

  addUtilisateurs = (data: UtilisateurInterface) => {
    this.service.addUtilisateur(data).subscribe(
      {
        next: (data: UtilisateurInterface) => {
          this.utilisateurs.push(data)
          console.log(data);
          
        },
        error: (err) => {
          console.log(err);
        }
      })
  }

  //méthode patchmdp a faire

}
