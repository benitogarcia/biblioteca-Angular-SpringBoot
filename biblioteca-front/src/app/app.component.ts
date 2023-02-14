import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RUTAS } from './core/rutas';
import { StorageService } from './shared/services/storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'biblioteca-front';

  constructor(private router: Router, private storage: StorageService) {

    if (storage.role && storage.token && storage.session) {
      router.navigate([RUTAS.APP.HOME]);
    }
  }

}
