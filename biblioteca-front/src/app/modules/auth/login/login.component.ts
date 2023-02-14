import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Subscription } from 'rxjs';
import { RUTAS } from 'src/app/core/rutas';
import { AuthService } from 'src/app/shared/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {

  pageRegister: string = RUTAS.AUTH.SIGNIN;
  hide = true;
  loginForm!: FormGroup;
  subsc!: Subscription;

  constructor(private auth: AuthService, private toastr: ToastrService) { }

  ngOnDestroy(): void {
    if(this.subsc) this.subsc.unsubscribe();
  }

  ngOnInit(): void {

    this.loginForm = new FormGroup({
      correo: new FormControl('', [Validators.required, Validators.email]),
      contrasena: new FormControl('', [Validators.required, Validators.pattern("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$")]),
    });

  }

  get correo() { return this.loginForm.get('correo'); }
  get contrasena() { return this.loginForm.get('contrasena'); }

  onSubmit(): void {

    this.loginForm.markAllAsTouched();

    if (this.loginForm.valid) {

      const login = {
        email: this.correo?.value,
        password: this.contrasena?.value
      };

      this.subsc = 
      this.auth.logIn(login).subscribe({
        next: (val) => {
          this.auth.authSuccess(val);
        },
        error: (error) => {
          console.log("<=== error ===>");
          console.log(error);
          let msg = (error.error.title) ? error.error.title : "Ocurrio un error inesperado!"

          this.toastr.error(error.error.title, "Error!");
        }
      });
    }

  }
}
