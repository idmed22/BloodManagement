import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Donor } from '../model/Donor';
import { Observable, catchError, count } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DonorService {
  private baseUrl = 'http://localhost:8080/api/donors';


  constructor(private http: HttpClient) { }

   // Add a new donor
   addDonor(donor: Donor): Observable<Donor> {
    return this.http.post<Donor>(this.baseUrl, donor);
  }

  // Get donor by ID
  getDonorById(id: number): Observable<Donor> {
    return this.http.get<Donor>(`${this.baseUrl}/${id}`);
  }

  // Get all donors
  getAllDonors(): Observable<Donor[]> {
    return this.http.get<Donor[]>(this.baseUrl);
  }

  // Update donor by ID
  updateDonor(id: number, donor: Donor): Observable<Donor> {
    return this.http.put<Donor>(`${this.baseUrl}/${id}`, donor);
  }

 
  
  // Delete donor by ID
  deleteDonor(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  // get donor count
  getDonorCount(): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/count`);
  }

  // get count of donors for each blood group
  // getCountByBloodGroup() {
  //   return this.http.get<Map<string,number>>(`${this.baseUrl}/countByBloodGroup`);
  // }

  getCountByBloodGroup(): Observable<Map<string, number>> {
    return this.http.get<Map<string, number>>(`${this.baseUrl}/countByBloodGroup`);
  }
}
