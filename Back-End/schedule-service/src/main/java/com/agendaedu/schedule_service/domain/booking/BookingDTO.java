package com.agendaedu.schedule_service.domain.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private Long id;
    private Long localId;
    private LocalDate date;
    private LocalTime checkIn;
    private LocalTime checkOut;
    private String course;
    private Long userId;

    public BookingDTO(BookingEntity bookingEntity) {
        this.id = bookingEntity.getId();
        this.localId = bookingEntity.getLocal().getId();
        this.date = bookingEntity.getDate();
        this.checkIn = bookingEntity.getCheckIn();
        this.checkOut = bookingEntity.getCheckOut();
        this.course = bookingEntity.getCourse();
        this.userId = bookingEntity.getUser().getId();
    }
}
