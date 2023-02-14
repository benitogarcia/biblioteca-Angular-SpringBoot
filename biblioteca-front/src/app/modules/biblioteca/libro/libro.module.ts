import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LibroRoutingModule } from './libro-routing.module';
import { LibrosComponent } from './libros/libros.component';
import { FormComponent } from './form/form.component';
import { ComponentsModule } from '../../components/components.module';


@NgModule({
  declarations: [
    LibrosComponent,
    FormComponent
  ],
  imports: [
    CommonModule,
    LibroRoutingModule,
    ComponentsModule
  ]
})
export class LibroModule { }
