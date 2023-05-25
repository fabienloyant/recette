import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UtilisateurInterface, UtilisateurModel } from 'src/app/models/UtilisateurModel';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-gestion-compte-form',
  templateUrl: './gestion-compte-form.component.html',
  styleUrls: ['./gestion-compte-form.component.css']
})
export class GestionCompteFormComponent implements OnInit {

  utilisateur: UtilisateurInterface = new UtilisateurModel()
  updateForm: any;

  public submitted: boolean = false


  createForm = () => {
    this.updateForm = this.fb.group({
      prenom : [this.utilisateur.prenom, [Validators.required]],
      nom: [this.utilisateur.nom, [Validators.required]],
      dateDeNaissance : ['', [Validators.required]],
      login : ['', [Validators.required]],
    })
  }

  constructor(private route: ActivatedRoute, private service: UtilisateurService, private fb: FormBuilder, private router: Router) {
    this.createForm()
  }

  ngOnInit(): void {
    const id: number = this.getId()
    this.getUtilisateurFromService(id)
  }

  //recupere l'id dans l'url
  getId = () => {
    return this.route.snapshot.params['id']
  }

  //récupère les données (de l'id en question) du service
  getUtilisateurFromService = (id: number) => {
    const data = this.service.getUtilisateurById(id).subscribe({
      next: (value) => {
        this.utilisateur = value;
        this.createForm()
      }
    })
  }

  public onSubmit = () => {
    this.submitted = true;

    if (this.updateForm.valid) {
      const data = Object.assign(this.utilisateur, this.updateForm.value)
      this.service.putUtilisateur(data).subscribe({
        next: (data: UtilisateurInterface) => {
          this.router.navigate([''])
        }
      })
    }
  }

}
