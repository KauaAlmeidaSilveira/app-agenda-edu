package com.agendaedu.schedule_service.domain.booking;

public enum BookingStatus {
    ACTIVE("Active"),
    DISABLED("Disabled");

    private final String status;

    BookingStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
