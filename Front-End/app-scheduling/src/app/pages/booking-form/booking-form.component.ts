import { Component } from '@angular/core';

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.component.html',
  styleUrl: './booking-form.component.scss'
})
export class BookingFormComponent {

  booking = {
    local: null,
    date: null,
    horarioEntrada: null,
    horarioSaida: null,
    turma: null,
  }

  locais = [
    { value: 'Sala de informática', viewValue: 'Sala de informática' },
    { value: 'Sala de ciências', viewValue: 'Sala de ciências' },
    { value: 'Sala de artes', viewValue: 'Sala de artes' },
    { value: 'Sala de psicomotricidade', viewValue: 'Sala de psicomotricidade' }
  ];

  horarioEntrada = [
    { value: '07:00', viewValue: '07:00' },
    { value: '08:00', viewValue: '08:00' },
    { value: '09:00', viewValue: '09:00' },
    { value: '10:00', viewValue: '10:00' },
    { value: '11:00', viewValue: '11:00' },
    { value: '12:00', viewValue: '12:00' },
    { value: '13:00', viewValue: '13:00' },
    { value: '14:00', viewValue: '14:00' },
    { value: '15:00', viewValue: '15:00' },
    { value: '16:00', viewValue: '16:00' },
    { value: '17:00', viewValue: '17:00' },
    { value: '18:00', viewValue: '18:00' },
    { value: '19:00', viewValue: '19:00' },
  ];

  horarioSaida = [
    { value: '07:00', viewValue: '07:00' },
    { value: '08:00', viewValue: '08:00' },
    { value: '09:00', viewValue: '09:00' },
    { value: '10:00', viewValue: '10:00' },
    { value: '11:00', viewValue: '11:00' },
    { value: '12:00', viewValue: '12:00' },
    { value: '13:00', viewValue: '13:00' },
    { value: '14:00', viewValue: '14:00' },
    { value: '15:00', viewValue: '15:00' },
    { value: '16:00', viewValue: '16:00' },
    { value: '17:00', viewValue: '17:00' },
    { value: '18:00', viewValue: '18:00' },
    { value: '19:00', viewValue: '19:00' },
  ];

  turmas = [
    { value: '1º Ano Fundamental', viewValue: '1º Ano Fundamental' },
    { value: '2º Ano Fundamental', viewValue: '2º Ano Fundamental' },
    { value: '3º Ano Fundamental', viewValue: '3º Ano Fundamental' },
    { value: '4º Ano Fundamental', viewValue: '4º Ano Fundamental' },
    { value: '5º Ano Fundamental', viewValue: '5º Ano Fundamental' },
    { value: '6º Ano Fundamental', viewValue: '6º Ano Fundamental' },
    { value: '7º Ano Fundamental', viewValue: '7º Ano Fundamental' },
    { value: '8º Ano Fundamental', viewValue: '8º Ano Fundamental' },
    { value: '9º Ano Fundamental', viewValue: '9º Ano Fundamental' },
    { value: '1º Ano Médio', viewValue: '1º Ano Médio' },
    { value: '2º Ano Médio', viewValue: '2º Ano Médio' },
    { value: '3º Ano Médio', viewValue: '3º Ano Médio' }
  ];

  showInfoBooking() {
    console.log(this.booking)
  }

}
