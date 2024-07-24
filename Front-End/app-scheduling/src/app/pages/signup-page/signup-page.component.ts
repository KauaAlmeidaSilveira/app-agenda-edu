import { Component } from '@angular/core';

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrl: './signup-page.component.scss'
})
export class SignupPageComponent {

  account = {
    email: '',
    password: '',
    confirmPassword: ''
  }

  submit() {
    console.log(`
      Email: ${this.account.email}\n
      Senha: ${this.account.password}\n
      Confirmação senha: ${this.account.confirmPassword}
      `);
  }

  setEmail(value: string) {
    this.account.email = value
  }

  setPassword(value: string) {
    this.account.password = value
  }

  setConfirmPassword(value: string) {
    this.account.confirmPassword = value
  }

}
