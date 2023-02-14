import { Injectable } from '@angular/core';
import { CryptoJsService } from './crypto-js.service';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  private KEYs = {
    usuario: "klg6TuyGpoiu", token: "aq15tghy67uj",
    role: "3EFV5T67UJ89QWE*"
  };

  constructor(private crypt: CryptoJsService) { }

  set session(user: any) { localStorage.setItem(this.KEYs.usuario, this.crypt.encrypt(JSON.stringify(user))); }
  get session() {
    let session = localStorage.getItem(this.KEYs.usuario);
    if (session == null) return null;
    return JSON.parse(this.crypt.decrypt(session));
  }

  set token(token: any) { localStorage.setItem(this.KEYs.token, this.crypt.encrypt(token)); }
  get token() {
    let token = localStorage.getItem(this.KEYs.token);
    if (token == null) return null;
    return this.crypt.decrypt(token);
  }

  set role(rol: any) { localStorage.setItem(this.KEYs.role, this.crypt.encrypt(rol)); }
  get role() { 
    let role = localStorage.getItem(this.KEYs.role);
    if (role == null) return null;
    return this.crypt.decrypt(role);
  }

}
