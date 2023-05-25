import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RecetteService {

  private URI = 'http://localhost:8080/recette';

  constructor(private http: HttpClient) {}

  

}
