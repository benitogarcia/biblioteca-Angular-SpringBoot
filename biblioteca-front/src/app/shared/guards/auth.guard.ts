import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { RUTAS } from 'src/app/core/rutas';
import { StorageService } from '../services/storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private storage: StorageService, private router: Router) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {

      //console.log(this.storage.getTokenSesion());
      //console.log(this.storage.getUsuarioSesion());
      

    if (this.storage.session && this.storage.token) {
      return true;
    } else {
      this.router.navigate([RUTAS.AUTH.LOGIN]);
      return false;
    }

  }

}
