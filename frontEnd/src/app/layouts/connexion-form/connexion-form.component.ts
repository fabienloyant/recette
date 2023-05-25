import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UtilisateurInterface, UtilisateurModel } from 'src/app/models/UtilisateurModel';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-connexion-form',
  templateUrl: './connexion-form.component.html',
  styleUrls: ['./connexion-form.component.css']
})
export class ConnexionFormComponent {

  @Output()
  data: EventEmitter<UtilisateurInterface> = new EventEmitter();


  public submitted: boolean = false

  connexionForm = this.fb.group({
    login : ['', [Validators.required]],
    mdp : ['', [Validators.required, Validators.minLength(8)]]
  })

  public constructor (private fb: FormBuilder) {}


  public onSubmit = () => {
    this.submitted = true; //passe le formulaire en soumis
    console.log(this.connexionForm);
    
    
    if (this.connexionForm.valid) { 
      const utilisateur: UtilisateurInterface = Object.assign(new UtilisateurModel(), this.connexionForm.value) //combiner les objets (si attributs identique entre 2 objets fusionne sinon creation de 2 obj
      this.data.emit(utilisateur) //on envoie le formulaire au parent
      this.connexionForm.reset()
      this.submitted = false

    }

  }


}
