import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { IngredientInterface, IngredientModel } from 'src/app/models/IngredientModel';

@Component({
  selector: 'app-afficher-ingredient',
  templateUrl: './afficher-ingredient.component.html',
  styleUrls: ['./afficher-ingredient.component.css']
})
export class AfficherIngredientComponent {

@Input()
data:IngredientInterface[] = [new IngredientModel()]

ingredients : IngredientInterface[] = []

constructor(private router: Router) {}

goToPageModifier(id: number) {
  this.router.navigate(['/modifierIngredient/:id'])
}

}
