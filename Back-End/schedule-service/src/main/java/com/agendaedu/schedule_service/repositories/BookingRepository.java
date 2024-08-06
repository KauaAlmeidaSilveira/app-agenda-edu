package com.agendaedu.schedule_service.repositories;

import com.agendaedu.schedule_service.domain.booking.BookingDTO;
import com.agendaedu.schedule_service.domain.booking.BookingEntity;
import com.agendaedu.schedule_service.projections.BookingProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    @Query(nativeQuery = true,
            value = """
                        SELECT *
                        FROM TB_BOOKING
                        WHERE LOCAL_ID = :localId
                        AND DATE = :date
                    """
    )
    List<BookingProjection> findBookingByDateAndLocal(LocalDate date, Long localId);

    List<BookingEntity> findByUserId(Long id);

}


