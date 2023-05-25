import { Component, OnInit } from '@angular/core';
import { UtilisateurInterface, UtilisateurModel } from 'src/app/models/UtilisateurModel';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private service: UtilisateurService) {}

}
