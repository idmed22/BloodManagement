import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Recipient } from '../model/Recipient';
import { Observable, Subject, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecipientService {
  private baseUrl = 'http://localhost:8080/api/recipients';

  constructor(private http: HttpClient) { }

  // Add a new recipient
  addRecipient(recipient: Recipient): Observable<Recipient> {
    return this.http.post<Recipient>(this.baseUrl, recipient);
  }

  // get recipient by ID
  getRecipientById(id:number): Observable<Recipient> {
    return this.http.get<Recipient>(`${this.baseUrl}/${id}`);
  }

  // get all recipients
  getAllRecipients(): Observable<Recipient[]> {
    return this.http.get<Recipient[]>(this.baseUrl);
  }

  // update recipient by ID
  updateRecipient(id: number, recipient: Recipient): Observable<Recipient> {
    return this.http.put<Recipient>(`${this.baseUrl}/${id}`, recipient);
  }

  // delete recipient
  deleteRecipient(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

   // get recipient count
   getRecipientCount(): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/count`);
  }

 

  
}
