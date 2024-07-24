import { Component, Input } from '@angular/core';

type InputTypes = 'text' | 'password' | 'email';

@Component({
  selector: 'app-primary-input',
  templateUrl: './primary-input.component.html',
  styleUrl: './primary-input.component.scss'
})
export class PrimaryInputComponent {

  @Input({required:true}) type: InputTypes = 'text';
  @Input({required:true}) placeholder: string = '';

}
