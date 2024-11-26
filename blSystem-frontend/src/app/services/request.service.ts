import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Request } from '../model/Request';
import { Donor } from '../model/Donor';

@Injectable({
  providedIn: 'root',
})
export class RequestService {
  private baseUrl = 'http://localhost:8080/api/requests';

  constructor(private http: HttpClient) {}

  // Add a new request
  addRequest(request: Request): Observable<Request> {
    return this.http.post<Request>(this.baseUrl, request);
  }

  // Get request by ID
  getRequestById(id: number): Observable<Request> {
    return this.http.get<Request>(`${this.baseUrl}/${id}`);
  }

  // Get all request
  getAllRequests(): Observable<Request[]> {
    return this.http.get<Request[]>(this.baseUrl);
  }

  // Update request by ID
  updateRequest(id: number, request: Request): Observable<Request> {
    return this.http.put<Request>(`${this.baseUrl}/${id}`, request);
  }

  // Delete request by ID
  deleteRequest(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  assignDonor(id: number, donor: Donor): Observable<string> {
    return this.http.post<string>(`${this.baseUrl}/${id}/assign-donor`, donor);
  }

  trackRequestStatus(id: number): Observable<string> {
    return this.http.get<string>(`${this.baseUrl}/${id}/status`);
  }
}
