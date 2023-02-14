import { Component, OnInit } from '@angular/core';
import { RUTAS } from 'src/app/core/rutas';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from 'src/app/shared/services/auth.service';
import { Subscription } from 'rxjs';
import { ToastrService } from 'ngx-toastr';
import { StorageService } from 'src/app/shared/services/storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {


  formSignin!: FormGroup;
  pageRegister: string = RUTAS.AUTH.LOGIN;
  hide = true;

  private subsc: Subscription[] = [];

  constructor(
    private auth_s: AuthService, private toastr: ToastrService,
    private storage: StorageService, private router: Router
  ) { }

  ngOnInit(): void {
    this.init();
  }

  private init(): void {
    this.formSignin = new FormGroup({
      nombres: new FormControl('JOSE BENITO', [Validators.required]),
      apellidos: new FormControl('GARCIA SOLANO', [Validators.required]),
      telefono: new FormControl('9921032908', [Validators.required]),
      email: new FormControl('JOOSBEEN2@GMAIL.COM', [Validators.required, Validators.email]),
      password: new FormControl('JOOSBEEN', [Validators.required, Validators.pattern("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$")]),
    });
  }

  get nombres() { return this.formSignin.get('nombres'); }
  get apellidos() { return this.formSignin.get('apellidos'); }
  get telefono() { return this.formSignin.get('telefono'); }
  get email() { return this.formSignin.get('email'); }
  get password() { return this.formSignin.get('password'); }

  onSubmit(): void {

    this.formSignin.markAllAsTouched();

    if (this.formSignin.valid) {
      const body = { ...this.formSignin.value, username: this.generatePassword() };
      this.subsc[this.subsc.length] =
        this.auth_s.signIn(body).subscribe(
          {
            next: (value) => {
             this.auth_s.authSuccess(value);
            },
            error: (error) => {
              console.log("<=== error ===>");
              console.log(error);
              let msg = (error.error.title) ? error.error.title : "Ocurrio un error inesperado!"

              this.toastr.error(error.error.title, "Error!");
            }
          }
        );

    }

  }

  private generatePassword() {

    const abc1 = "abcdefghijklmnopqrstuvwxyz";
    const abc2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    let username = "";

    let text: number = this.numberRandow();
    username += (text % 2 == 0) ? text : abc1[text];

    text = this.numberRandow();
    username += (text % 2 == 0) ? text : abc2[text];

    text = this.numberRandow();
    username += (text % 2 == 0) ? text : abc1[text];

    text = this.numberRandow();
    username += ((text % 2 == 0) ? text : abc2.charAt(text));

    text = this.numberRandow();
    username += ((text % 2 == 0) ? text : abc1.charAt(text));

    text = this.numberRandow();
    username += ((text % 2 == 0) ? text : abc2.charAt(text));

    text = this.numberRandow();
    username += ((text % 2 == 0) ? text : abc1.charAt(text));

    text = this.numberRandow();
    username += ((text % 2 == 0) ? text : abc2.charAt(text));

    return username;

  }

  private numberRandow(): number {
    const r = Math.floor(Math.random() * 27);
    return r;
  }
}
