package com.agendaedu.schedule_service.projections;

import java.time.LocalDate;
import java.time.LocalTime;

public interface BookingProjection {
    Long getId();

    String getCourse();

    LocalDate getDate();

    LocalTime getCheckIn();

    LocalTime getCheckOut();

    Long getLocalId();

    Long getUserId();
}
