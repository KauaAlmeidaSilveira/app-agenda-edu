package com.agendaedu.schedule_service.repositories;

import com.agendaedu.schedule_service.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
