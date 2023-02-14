import { Component } from '@angular/core';
import { RUTAS } from 'src/app/core/rutas';

@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrls: ['./libros.component.css']
})
export class LibrosComponent {

  linkPage: string = RUTAS.APP.LIBRO.FORM;

}
