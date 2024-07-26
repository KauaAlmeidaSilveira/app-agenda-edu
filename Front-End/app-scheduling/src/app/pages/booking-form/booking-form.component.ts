import { Component } from '@angular/core';

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.component.html',
  styleUrl: './booking-form.component.scss'
})
export class BookingFormComponent {

  locais = [
    {
      value: 1,
      viewValue: 'Sala de informática'
    },
    {
      value: 2,
      viewValue: 'Sala de ciências'
    },
    {
      value: 3,
      viewValue: 'Sala de artes'
    },
    {
      value: 4,
      viewValue: 'Sala de psicomotricidade'
    }, 
  ]

  setTest(){

  }

}
