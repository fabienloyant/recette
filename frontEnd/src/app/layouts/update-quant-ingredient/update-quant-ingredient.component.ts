import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IngredientInterface, IngredientModel } from 'src/app/models/IngredientModel';
import { IngredientService } from 'src/app/services/ingredient.service';

@Component({
  selector: 'app-update-quant-ingredient',
  templateUrl: './update-quant-ingredient.component.html',
  styleUrls: ['./update-quant-ingredient.component.css']
})
export class UpdateQuantIngredientComponent {

  ingredient: IngredientInterface = new IngredientModel();

  public submitted: boolean = false
  
  constructor(private route: ActivatedRoute, private service: IngredientService) {}

  ngOnInit(): void {
    const id: number = this.getId()
    this.getIngredientFromService(id)    
  }


  getId = () => {
    return this.route.snapshot.params['id']
  }


  getIngredientFromService = (id: number) => {
    const data = this.service.getIngredientById(id).subscribe(
      {
        next: (value) => {
          this.ingredient = value;
        }
    })
  }

  // quantite = (id: number) => {

  //  if(this.ingredient) {
  //   this.ingredient.
  //  }
  // }


}
