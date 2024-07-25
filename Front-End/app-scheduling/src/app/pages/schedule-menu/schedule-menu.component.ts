import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-schedule-menu',
  templateUrl: './schedule-menu.component.html',
  styleUrl: './schedule-menu.component.scss'
})
export class ScheduleMenuComponent {

  bookings = [
    {
      location: 'Sala 101',
      startTime: '08:00',
      endTime: '10:00',
      date: '20/11',
      class: 'Turma A'
    },
    {
      location: 'Sala 102',
      startTime: '10:00',
      endTime: '12:00',
      date: '20/11',
      class: 'Turma B'
    },
    {
      location: 'Laboratório de Química',
      startTime: '13:00',
      endTime: '15:00',
      date: '20/11',
      class: 'Turma C'
    },
    {
      location: 'Teatro',
      startTime: '15:00',
      endTime: '17:00',
      date: '20/11',
      class: 'Turma D'
    },
    {
      location: 'Sala de Informática',
      startTime: '09:00',
      endTime: '11:00',
      date: '20/11',
      class: 'Turma E'
    },
    {
      location: 'Sala de Informática',
      startTime: '09:00',
      endTime: '11:00',
      date: '20/11',
      class: 'Turma E'
    },
    {
      location: 'Sala de Informática',
      startTime: '09:00',
      endTime: '11:00',
      date: '20/11',
      class: 'Turma E'
    }
  ];

  constructor(private router: Router) {}

  navigate(page: string){
    if(page === 'bookingForm'){
      this.router.navigate(['/bookingForm'])
    }
  }
}
