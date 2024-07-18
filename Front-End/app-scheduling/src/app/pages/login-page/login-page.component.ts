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

    onClick() {
        console.log(this.account.email)
        console.log(this.account.password)
    }
}
