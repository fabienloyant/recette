import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UtilisateurInterface, UtilisateurModel } from 'src/app/models/UtilisateurModel';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(private service: UtilisateurService, private router: Router) {}


  login = (data: UtilisateurInterface) => {
    this.service.login(data).subscribe(
      {
        next: (data: UtilisateurInterface) => {
          this.service.connecterUtilisateur(data);
          this.router.navigateByUrl('/recette');
          // console.log(this.service.isLoggedIn);
          // console.log(this.service.utilisateur);
        }, 
        error: (err) => {
          this.service.deconnecterUtilisateur();
          // console.log(this.service.isLoggedIn);
          // console.log(this.service.utilisateur);
          console.log(err);
        }
      })
  }

}
