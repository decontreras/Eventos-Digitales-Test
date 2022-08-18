import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TypeEventService {

  private apiUrl = environment.apiURL;

  constructor(
    private readonly http: HttpClient
  ) { }

  getTypeEvent() {
    return this.http.get<any>(`${this.apiUrl}/typeEvents`);
  }
  
}
