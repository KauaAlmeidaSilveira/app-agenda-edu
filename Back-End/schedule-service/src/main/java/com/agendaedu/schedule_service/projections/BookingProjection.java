package com.agendaedu.schedule_service.projections;

public interface BookingProjection {
    Long getId();
    String getCourse();
    String getDate();
    String getCheckIn();
    String getCheckOut();
    String getLocalId();
    String getUserId();
}
