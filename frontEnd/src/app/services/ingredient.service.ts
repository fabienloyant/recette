import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IngredientInterface, TypeIngredient, Unite } from '../models/IngredientModel';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  private URI = 'http://localhost:8080/ingredient'


  constructor(private http: HttpClient) { }


  getIngredients = (): Observable<IngredientInterface[]> => {
    return this.http.get<IngredientInterface[]>(`${this.URI}`)
  }

  getIngredientById = (id: number): Observable<IngredientInterface> => {
    return this.http.get<IngredientInterface>(`${this.URI}/${id}`)
  }

  getIngredientByUtilisateurId = (id: number): Observable<IngredientInterface> =>{
    return this.http.get<IngredientInterface>(`${this.URI}/${id}/withingredients`)
  }

  // //méthode pour faire un filtre (afficher les ingredients que quand type ingredient est legume ) MAIS ne marche pas 
  //  getIngredientByType = (): Observable<void> => {
  //    const ingredients =  this.http.get<IngredientInterface[]>(`${this.URI}`)
  //    const result = ingredients.filter(ingredient => ingredient.type = TypeIngredient.legume);
  //    console.log(result);
  //  }

  //méthode ajout ingredient
  addIngredient = (data: IngredientInterface): Observable<IngredientInterface> => {
    return this.http.post<IngredientInterface>(`${this.URI}`, data)
  }

  //méthode modif quantite ingr
  patchQuantite = (id: number, data = ""): Observable<IngredientInterface> => {
    return this.http.patch<IngredientInterface>(`${this.URI}/${id}`, data)
  }

  //delete ingredient
  deleteIngredient = (id: number): Observable<void> => {
    return this.http.delete<void>(`${this.URI}/${id}`)
  }

}
