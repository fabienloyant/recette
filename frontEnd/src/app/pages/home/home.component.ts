import { Component, Input, OnInit } from '@angular/core';
import { UtilisateurInterface } from 'src/app/models/UtilisateurModel';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  utilisateurs: UtilisateurInterface[] = []
  

  constructor(private service: UtilisateurService) {}

  


  login = (data: UtilisateurInterface) => {
    this.service.login(data).subscribe(
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

}
