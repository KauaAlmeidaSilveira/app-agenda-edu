import { Component, EventEmitter, Input, Output } from '@angular/core';


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

  @Input({ required: true }) booking: booking_item = {
    location: '',
    startTime:'',
    endTime:'',
    date:'',
    class:''
  };

  @Output() cancelBookingEmmit = new EventEmitter<booking_item>();

  cancelBooking() {
    this.cancelBookingEmmit.emit(this.booking);
  }
}
