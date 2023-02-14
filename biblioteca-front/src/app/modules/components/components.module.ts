import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderListComponent } from './header-list/header-list.component';
import { MaterialModule } from 'src/app/core/modules/material/material.module';

@NgModule({
  declarations: [
    HeaderListComponent
  ],
  imports: [
    CommonModule,
    MaterialModule
  ],
  exports: [
    HeaderListComponent
  ],
})
export class ComponentsModule { }
