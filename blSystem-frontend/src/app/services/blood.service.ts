import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Blood } from '../model/Blood';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BloodService {
  private baseUrl = 'http://localhost:8080/api/bloods';

  constructor(private http: HttpClient) { }

  addBlood(blood: Blood): Observable<Blood> {
    return this.http.post<Blood>(this.baseUrl, blood);
  }

  getBloodById(id: number): Observable<Blood> {
    return this.http.get<Blood>(`${this.baseUrl}/${id}`);
  }

  getAllBloods(): Observable<Blood[]> {
    return this.http.get<Blood[]>(this.baseUrl);
  }

  updateBlood(id: number, blood: Blood): Observable<Blood> {
    return this.http.put<Blood>(`${this.baseUrl}/${id}`, blood);
  }

  deleteBlood(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
