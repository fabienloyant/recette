import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UtilisateurInterface, UtilisateurModel } from 'src/app/models/UtilisateurModel';

@Component({
  selector: 'app-inscription-form',
  templateUrl: './inscription-form.component.html',
  styleUrls: ['./inscription-form.component.css']
})
export class InscriptionFormComponent {

  @Output()
  data: EventEmitter<UtilisateurInterface> = new EventEmitter();


  //boolean qui vérifie si le formulaire est soumis
  public submitted: boolean = false


  //création du formulaire coté ts
  utilisateurForm = this.fb.group({
    prenom : ['', [Validators.required]], 
    nom : ['', [Validators.required]],
    dateDeNaissance : ['', [Validators.required]],
    login : ['', [Validators.required]],
    mdp : ['', [Validators.required, Validators.minLength(8)]]
  })

  //constructeur
  public constructor (private fb: FormBuilder) {}


  //méthode qui se lance à la soumission du formulaire
  public onSubmit = () => {
    this.submitted = true; //passe le formulaire en soumis
    console.log(this.utilisateurForm);
    
    
    if (this.utilisateurForm.valid) { 
      const utilisateur: UtilisateurInterface = Object.assign(new UtilisateurModel(), this.utilisateurForm.value) //combiner les objets (si attributs identique entre 2 objets fusionne sinon creation de 2 obj
      this.data.emit(utilisateur) //on envoie le formulaire au parent
      this.utilisateurForm.reset()
      this.submitted = false

    }

  }

}
