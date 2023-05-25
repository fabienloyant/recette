import { Component, EventEmitter, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IngredientInterface, IngredientModel } from 'src/app/models/IngredientModel';
import { IngredientService } from 'src/app/services/ingredient.service';

@Component({
  selector: 'app-modifier-ingredient',
  templateUrl: './modifier-ingredient.component.html',
  styleUrls: ['./modifier-ingredient.component.css']
})
export class ModifierIngredientComponent {

  ingredient: IngredientInterface = new IngredientModel()

  constructor(private route:ActivatedRoute, private service: IngredientService) {}

  ngOnInit(): void {
    const id: number = this.getId()
    this.getIngredientFromService();
}

  getId = () => {
    return this.route.snapshot.params['id'];
  }

  getIngredientFromService = () => {
    const id: number = this.getId();
    const data = this.service.getIngredientById(id).subscribe({
      next : (value) => {
        this.ingredient = value;
      }
    });
  }

}
