package com.agendaedu.schedule_service.domain.dto;

import com.agendaedu.schedule_service.domain.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private Long id;
    private String local;

    public BookingDTO(Booking booking){
        this.id = booking.getId();
        this.local = booking.getLocal();
    }
}
