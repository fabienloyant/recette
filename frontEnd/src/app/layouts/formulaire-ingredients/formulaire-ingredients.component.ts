import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { IngredientInterface, IngredientModel, TypeIngredient, Unite } from 'src/app/models/IngredientModel';
import { IngredientService } from 'src/app/services/ingredient.service';

@Component({
  selector: 'app-formulaire-ingredients',
  templateUrl: './formulaire-ingredients.component.html',
  styleUrls: ['./formulaire-ingredients.component.css']
})
export class FormulaireIngredientsComponent implements OnInit {

   @Output()
   data: EventEmitter<IngredientInterface> = new EventEmitter();
  
  unite : Unite[]= [Unite.INGREDIENT, Unite.G, Unite.ML]

  typeIngredient: TypeIngredient[] = [TypeIngredient.LEGUME, TypeIngredient.LEGUMINEUSE, TypeIngredient.BOISSON,
    TypeIngredient.VIANDE, TypeIngredient.EPICE, TypeIngredient.FECULENT, TypeIngredient.LAITAGE, TypeIngredient.POISSON,
  TypeIngredient.FRUIT ]

//boolean qui vérifie si le formulaire est soumis
  public submitted: boolean = false

//   création du form coté ts
   ingredientForm = this.fb.group({
     nom : ['', [Validators.required]],
     unite: ['', [Validators.required]],
     typeIngredient: ['', [Validators.required]],
     quantite:['',[Validators.required]]
   })


  //constructeur
   public constructor (private fb: FormBuilder) {}

   ngOnInit(): void {
//     this.listIngredients = this.service.getIngredients()
     console.log("valide");
    
   }



  //méthode qui se lance à la soumission du formulaire
  public onSubmit = () => {
    this.submitted = true; //passe le form en soumis
    console.log(this.ingredientForm);
    

    if (this.ingredientForm.valid) { //dans le cas ou le formulaire est valid
      //on fusionne les donnée du formulaire avec un objet IngredientModel
      const ingredient: IngredientInterface = Object.assign(new IngredientModel(), this.ingredientForm.value)
      this.data.emit(ingredient) //on envoie le formulaire au parent (page ingredient)
      this.ingredientForm.reset()
      this.submitted = false
    }
  }

 }
