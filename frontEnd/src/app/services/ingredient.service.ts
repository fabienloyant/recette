import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IngredientInterface, TypeIngredient, Unite } from '../models/IngredientModel';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  private URI = 'http://localhost:8080/ingredient'

  private ingredientMock: IngredientInterface[] = [
    {
      id: 1,
      nom: "carotte",
      unite: Unite.g,
      typeIngredient: TypeIngredient.legume
    },
    {
      id: 2,
      nom: "salade",
      unite: Unite.ingredient,
      typeIngredient: TypeIngredient.legume
    },
    {
      id: 3,
      nom: "fraise",
      unite: Unite.g,
      typeIngredient: TypeIngredient.fruit
    }
  ]

  constructor(private http: HttpClient) { }


  getIngredients = () => {
    return this.ingredientMock
  }

  getIngredientsByType = () => {
   
  }


  //méthode ajout ingredient
  addIngredient = (data: IngredientInterface): Observable<IngredientInterface> => {
    return this.http.post<IngredientInterface>(`${this.URI}`, data)
  }

}
