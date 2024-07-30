package com.agendaedu.schedule_service.repositories;

import com.agendaedu.schedule_service.domain.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
