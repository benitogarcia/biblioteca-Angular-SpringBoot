import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { APIs } from 'src/app/core/apis';
import { RUTAS } from 'src/app/core/rutas';
import { StorageService } from './storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private router: Router, private storage: StorageService) { }

  signIn(data: any): Observable<any> {
    return this.http.post(APIs.auth.signin, data);
  }

  logIn(data: any): Observable<any> {
    return this.http.post(APIs.auth.login, data);
  }

  authSuccess(data: any): void {    
    const user: { nombres: string, role: string, username: string, apellidos: string } = data; 
    this.storage.session = user;
    this.storage.token = data.token;
    this.storage.role = data.role;
    this.router.navigate([RUTAS.APP.HOME]);
  }

}
