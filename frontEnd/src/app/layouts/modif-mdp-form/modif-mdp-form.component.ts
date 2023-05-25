import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UtilisateurInterface, UtilisateurModel } from 'src/app/models/UtilisateurModel';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-modif-mdp-form',
  templateUrl: './modif-mdp-form.component.html',
  styleUrls: ['./modif-mdp-form.component.css']
})
export class ModifMdpFormComponent implements OnInit {

//     utilisateur: UtilisateurInterface = new UtilisateurModel()


//     createForm = () => {
//       this.updateMdpForm = this.fb.group({
//         password1 : [this.utilisateur.prenom, [Validators.required]],
//         password2 : [this.utilisateur.nom, [Validators.required]],
//         password3 : ['', [Validators.required]],
//       })
//     }

//     constructor(private route: ActivatedRoute, private service: UtilisateurService, private fb: FormBuilder, private router: Router) {
//       this.createForm()
//     }

     ngOnInit(): void {
//       const id: number = this.getId()
//       this.getMdpFromService(id)
        console.log("test");

     }

//     //recupere l'id dans l'url
//     getId = () => {
//     return this.route.snapshot.params['id']
//     }

//     //récupère les données (de l'id en question) du service
//     getMdpFromService = (id: number) => {
//       const data = this.service.patchMdp.subscribe({
//         next: (value) => {
//           this.utilisateur = value;
//           this.createForm()
//         }
//       })
//     }

//     //méthode qui update le checked (le passe a true) des données du service 
//     checked = (id: number) => {
//       //this.service.checked(id)

//       const todo = this.todos.find(item => item.id == id) //on recupere l'obj dans le tableau via son id
//       if(todo) { //si j'ai un obj
//         todo.checked = !todo.checked //on change l'état du boolean checked de l'obj

//         this.service.patchChecked(id).subscribe( { //j'envoie les données au service
//           next: (value) => { //quand le service me répond
//             const pos = this.todos.indexOf(todo) // je récupère la position dans le tableau de la todo
//             this.todos[pos].checked = value.checked // je change la valeur dans le tableau
//           }
//         }) 
//       }
//     }

 }
