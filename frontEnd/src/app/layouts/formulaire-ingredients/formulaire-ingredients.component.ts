import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { TYPE_INGREDIENT } from 'src/app/constants/typeIngredient';
import { IngredientInterface, IngredientModel, TypeIngredient } from 'src/app/models/IngredientModel';
import { IngredientService } from 'src/app/services/ingredient.service';

@Component({
  selector: 'app-formulaire-ingredients',
  templateUrl: './formulaire-ingredients.component.html',
  styleUrls: ['./formulaire-ingredients.component.css']
})
export class FormulaireIngredientsComponent implements OnInit {

  @Output()
  data: EventEmitter<IngredientInterface> = new EventEmitter();

  public listIngredients: IngredientModel [] = []

  public types = TYPE_INGREDIENT;


  //boolean qui vérifie si le formulaire est soumis
  public submitted: boolean = false

  //création du form coté ts
  ingredientForm = this.fb.group({
    nom : ['', [Validators.required]],
    unite: ['', [Validators.required]],
    typeIngredient: ['', [Validators.required]]
  })


  //constructeur
  public constructor (private fb: FormBuilder, private service: IngredientService) {}

  ngOnInit(): void {
    this.listIngredients = this.service.getIngredients()
    console.log(this.listIngredients);
    
  }

  //méthode qui se lance à la soumission du formulaire
  public onSubmit = () => {
    this.submitted = true; //passe le form en soumis

    if (this.ingredientForm.valid) { //dans le cas ou le formulaire est valid
      //on fusionne les donnée du formulaire avec un objet IngredientModel
      const ingredient: IngredientInterface = Object.assign(new IngredientModel(), this.ingredientForm.value)
      this.data.emit(ingredient) //on envoie le formulaire au parent (page ingredient)
      this.ingredientForm.reset()
      this.submitted = false
    }
  }

}
