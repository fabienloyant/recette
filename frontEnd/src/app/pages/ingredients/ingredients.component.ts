import { Component, OnInit } from '@angular/core';
import { IngredientInterface } from 'src/app/models/IngredientModel';
import { IngredientService } from 'src/app/services/ingredient.service';

@Component({
  selector: 'app-ingredients',
  templateUrl: './ingredients.component.html',
  styleUrls: ['./ingredients.component.css']
})
export class IngredientsComponent implements OnInit {

  ingredients: IngredientInterface[] = []

  //injection du service
  constructor(private service: IngredientService) {}

    ngOnInit() {
      this.getIngredient()
    }

    getIngredient = () => {
      this.service.getIngredients().subscribe(
        {
          next: (data: IngredientInterface[]) => {
            this.ingredients = data;
          },
          error: (err) => {
            console.log(err);
          },
          complete: () => {
            console.log("complete");
          }
        })
    }

   addIngredient = (data: IngredientInterface) => {
     this.service.addIngredient(data).subscribe(
       {
         next: (data: IngredientInterface) => {
           this.ingredients.push(data)
           console.log(data);
           
         },
         error: (err) => {
           console.error(err);
         }
       })
   }

   deleteIngredient = (id: number) => {
    this.service.deleteIngredient(id).subscribe({
      next: () => {
        for (let i=0; i<this.ingredients.length; i++) {
          if(this.ingredients[i].id == id) {
            this.ingredients.splice(i, 1)
          }
        }
      }
    })
   }
   

}
