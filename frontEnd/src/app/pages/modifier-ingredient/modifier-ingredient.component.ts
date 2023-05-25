import { Component } from '@angular/core';
import { IngredientInterface, IngredientModel } from 'src/app/models/IngredientModel';
import { IngredientService } from 'src/app/services/ingredient.service';

@Component({
  selector: 'app-modifier-ingredient',
  templateUrl: './modifier-ingredient.component.html',
  styleUrls: ['./modifier-ingredient.component.css']
})
export class ModifierIngredientComponent {

  ingredient: IngredientInterface = new IngredientModel();

  constructor(private service: IngredientService) {}

  ngOnInit() {
    this.getIngredientById()
  }

  getIngredientById = (id: number) => {
    this.service.getIngredientById(id).subscribe(
      {
        next: (data: IngredientModel) => {
          this.ingredient = data;
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
