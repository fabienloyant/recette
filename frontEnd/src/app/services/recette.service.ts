import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RecetteInterface } from '../models/RecetteModel';

@Injectable({
  providedIn: 'root'
})
export class RecetteService {

  private URI = 'http://localhost:8080/recette';

  constructor(private http: HttpClient) {}

  getRecettes = (): Observable<RecetteInterface[]> => {
    return this.http.get<RecetteInterface[]>(`${this.URI}`);
  }

}
