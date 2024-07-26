import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-default-login-layout',
  templateUrl: './default-login-layout.component.html',
  styleUrl: './default-login-layout.component.scss'
})
export class DefaultLoginLayoutComponent {

  @Input({required:true}) title: 'Login' | 'Cadastro' = 'Login'
  @Input({required:true}) btnText: string = ''
  @Input({required:true}) pageType: 'Login' | 'Signup' = 'Login'

  @Output("submit") onSubmitEmmit = new EventEmitter();

  submit(){
    this.onSubmitEmmit.emit();
  }

  constructor(private router: Router) {}

  navigate(page: string){
    if(page === 'Login'){
      this.router.navigate(['/login'])
    }else if(page === 'Signup'){
      this.router.navigate(['/signup'])
    }
  }

}
