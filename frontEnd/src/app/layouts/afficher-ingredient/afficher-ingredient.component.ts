import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { IngredientInterface } from 'src/app/models/IngredientModel';

@Component({
  selector: 'app-afficher-ingredient',
  templateUrl: './afficher-ingredient.component.html',
  styleUrls: ['./afficher-ingredient.component.css']
})
export class AfficherIngredientComponent {

  @Output()
  data: EventEmitter<IngredientInterface> =  new EventEmitter();
  

  public submitted: boolean = false

  todoForm = this.fb.group({
    nom:['', [Validators.required, Validators.minLength]]
    

  })

  constructor(private fb: FormBuilder){}
}
