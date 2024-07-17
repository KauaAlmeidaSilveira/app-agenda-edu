import { Component } from '@angular/core';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrl: './login.component.scss'
})
export class LoginComponent {

    account = {
        email: '',
        password: ''
    }

    onClick() {
        console.log(this.account.email)
        console.log(this.account.password)
    }

}
