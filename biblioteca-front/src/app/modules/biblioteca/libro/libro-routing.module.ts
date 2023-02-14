import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormComponent } from './form/form.component';
import { LibrosComponent } from './libros/libros.component';

const routes: Routes = [
  {
    path: "",
    component: LibrosComponent
  }, {
    path: "nuevo",
    component: FormComponent
  }, {
    path: "editar/:id",
    component: FormComponent
  }, {
    path: "**",
    redirectTo: ""
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LibroRoutingModule { }
