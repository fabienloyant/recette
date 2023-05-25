import { Component, Input, Output } from '@angular/core';
import { UtilisateurInterface, UtilisateurModel } from './models/UtilisateurModel';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontEnd';

  utilisateur: UtilisateurInterface = new UtilisateurModel;

  @Output()
  userConnected: boolean = false;

}
