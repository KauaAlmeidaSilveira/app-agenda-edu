import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-auth-form',
  templateUrl: './auth-form.component.html',
  styleUrl: './auth-form.component.scss'
})
export class AuthFormComponent {

  account = {
    email: '',
    password: ''
  }

  ngOnInit() {
    console.log(this.mode);
  }

  @Input() mode: 'login' | 'register' = 'register'

}
