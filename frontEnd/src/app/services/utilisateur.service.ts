import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UtilisateurInterface, UtilisateurModel } from '../models/UtilisateurModel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  // isLoggedIn: boolean = false;
  // utilisateur: UtilisateurInterface = new UtilisateurModel();

  private URI = 'http://localhost:8080/utilisateur'

  constructor(private http: HttpClient) { }

  getUtilisateurs = (): Observable<UtilisateurInterface[]> => {
    return this.http.get<UtilisateurInterface[]>(`${this.URI}`)
  }

  getUtilisateurById = (id: number): Observable<UtilisateurInterface> => {
    return this.http.get<UtilisateurInterface>(`${this.URI}/${id}`)
  }

  login = (data: UtilisateurInterface): Observable<UtilisateurInterface> => {
    return this.http.post<UtilisateurInterface>(`${this.URI}/login`, data)
  }

  connecterUtilisateur = (data: UtilisateurModel) => {
    localStorage.setItem('isLoggedIn', "true");
    localStorage.setItem('utilisateur', JSON.stringify(data));
  }

  deconnecterUtilisateur = () => {
    localStorage.setItem('isLoggedIn', "false");
    localStorage.setItem('utilisateur', JSON.stringify(new UtilisateurModel()));
  }

  addUtilisateur = (data: UtilisateurInterface): Observable<UtilisateurInterface> => {
    return this.http.post<UtilisateurInterface>(`${this.URI}`, data)
  }

  putUtilisateur = (data: UtilisateurInterface): Observable<UtilisateurInterface> => {
    return this.http.put<UtilisateurInterface>(`${this.URI}/${data.id}`, data)
  }

  patchMdp = (id: number, data = ""): Observable<UtilisateurInterface> => {
    return this.http.patch<UtilisateurInterface>(`${this.URI}/${id}`, data)
  }
}
