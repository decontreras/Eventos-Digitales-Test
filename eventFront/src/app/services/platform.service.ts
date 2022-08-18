import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PlatformService {

  private apiUrl = environment.apiURL;

  constructor(
    private readonly http: HttpClient
  ) { }

  getPlatform() {
    return this.http.get<any>(`${this.apiUrl}/platforms`);
  }
  
}
