import { Component, Input } from '@angular/core';


type booking_item = {
  location: string,
  startTime: string,
  endTime: string,
  date: string,
  class: string
}

@Component({
  selector: 'app-booking-item',
  templateUrl: './booking-item.component.html',
  styleUrl: './booking-item.component.scss'
})
export class BookingItemComponent {

  booking_item = {
    location: '',
    startTime: '',
    endTime: '',
    date: '',
    class: ''
  }

  @Input({ required: true }) booking: booking_item = this.booking_item;
}
