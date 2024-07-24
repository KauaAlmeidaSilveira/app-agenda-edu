import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-default-login-layout',
  templateUrl: './default-login-layout.component.html',
  styleUrl: './default-login-layout.component.scss'
})
export class DefaultLoginLayoutComponent {

  @Input({required:true}) title: string = ''
  @Input({required:true}) btnText: string = ''

  @Output("submit") onSubmit = new EventEmitter();

  submit(){
    this.onSubmit.emit();
  }

}
