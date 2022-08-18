import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private apiUrl = environment.apiURL;

  constructor(
    private readonly http: HttpClient
  ) { }

  getEvent() {
    return this.http.get<any>(`${this.apiUrl}/events`);
  }

  postEvent(data: any): Observable<any> {
    return this.http.post(`${environment.apiURL}/events`, data)
  }

  putEvent(data: any, id: any): Observable<any> {
    return this.http.put(`${environment.apiURL}/events/${id}`, data)
  }

  deleteEvent(id: any): Observable<any> {
    return this.http.delete(`${environment.apiURL}/events/${id}`)
  }
  
}
