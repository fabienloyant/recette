import { Component, OnInit } from '@angular/core';
import { RecetteInterface } from 'src/app/models/RecetteModel';
import { RecetteService } from 'src/app/services/recette.service';

@Component({
  selector: 'app-recettes',
  templateUrl: './recettes.component.html',
  styleUrls: ['./recettes.component.css']
})
export class RecettesComponent implements OnInit {

  recettes: RecetteInterface[] = []; // tableau de recettes

  constructor(private service: RecetteService) {}

  ngOnInit() {
    this.getRecette()
  }

  getRecette = () => {
    this.service.getRecettes().subscribe({
      next: (data: RecetteInterface[]) => {
        this.recettes = data;
      },
      error: (err) => {
        console.error(err);
      },
      complete: () => {
        console.log("complete");
      }
    })
  }

}
