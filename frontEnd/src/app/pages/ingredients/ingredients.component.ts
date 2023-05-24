import { Component, OnInit } from '@angular/core';
import { IngredientInterface } from 'src/app/models/IngredientModel';
import { IngredientService } from 'src/app/services/ingredient.service';

@Component({
  selector: 'app-ingredients',
  templateUrl: './ingredients.component.html',
  styleUrls: ['./ingredients.component.css']
})
export class IngredientsComponent {

  ingredients: IngredientInterface[] =[]

  //injection du service
  //constructor(private service: IngredientService) {}

  //  ngOnInit() {
  //    this.getIngredient()
  //  }


  // addIngredient = (data: IngredientInterface) => {
  //   this.service.addIngredient(data).subscribe(
  //     {
  //       next: (data: IngredientInterface) => {
  //         this.ingredients.push(data)
  //       },
  //       error: (err) => {
  //         console.error(err);
  //       }
  //     })
  // }



}
