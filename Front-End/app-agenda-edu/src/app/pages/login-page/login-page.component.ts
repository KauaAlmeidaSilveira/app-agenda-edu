import { Component } from '@angular/core';

@Component({
    selector: 'app-login-page',
    templateUrl: './login-page.component.html',
    styleUrl: './login-page.component.scss',
})
export class LoginPageComponent {

    account = {
        email: '',
        password: ''
    }

    submit() {
        console.log(`Email: ${this.account.email}\nSenha: ${this.account.password}`);
    }

    setEmail(value: string){
        this.account.email = value
    }

    setPassword(value: string){
        this.account.password = value
    }
}
