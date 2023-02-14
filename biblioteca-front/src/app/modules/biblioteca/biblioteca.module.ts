import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BibliotecaRoutingModule } from './biblioteca-routing.module';
import { HomeComponent } from './home/home.component';
import { MaterialModule } from 'src/app/core/modules/material/material.module';


@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    CommonModule,
    BibliotecaRoutingModule,
    MaterialModule
  ]
})
export class BibliotecaModule { }
