import { Component } from '@angular/core';

interface Turma {
	value: string,
	viewValue: string
}

interface TurmaGroup {
	name: string,
	turma: Turma[]
}

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

	turmaGroups: TurmaGroup[] = [
		{
			name: 'Ensino Infantil',
			turma: [
				{ value: 'Maternal', viewValue: 'Maternal' },
				{ value: 'Jardim', viewValue: 'Jardim' },
				{ value: 'Pre', viewValue: 'Pré' }
			]
		},
		{
			name: 'Ensino Fundamental',
			turma: [
				{ value: '1º Ano', viewValue: '1º Ano' },
				{ value: '2º Ano', viewValue: '2º Ano' },
				{ value: '3º Ano', viewValue: '3º Ano' },
				{ value: '4º Ano', viewValue: '4º Ano' },
				{ value: '5º Ano', viewValue: '5º Ano' },
				{ value: '6º Ano', viewValue: '6º Ano' },
				{ value: '7º Ano', viewValue: '7º Ano' },
				{ value: '8º Ano', viewValue: '8º Ano' },
				{ value: '9º Ano', viewValue: '9º Ano' },
			]
		},
		{
			name: 'Ensino Médio',
			turma: [
				{ value: '1º Serie', viewValue: '1º Serie' },
				{ value: '2º Serie', viewValue: '2º Serie' },
				{ value: '3º Serie', viewValue: '3º Serie' }
			]
		}
	]

	showInfoBooking() {
		console.log(this.booking)
	}

}
