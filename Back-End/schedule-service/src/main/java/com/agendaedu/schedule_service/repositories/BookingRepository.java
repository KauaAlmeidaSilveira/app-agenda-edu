package com.agendaedu.schedule_service.repositories;

import com.agendaedu.schedule_service.domain.booking.BookingEntity;
import com.agendaedu.schedule_service.projections.BookingProjection;
import com.agendaedu.schedule_service.projections.BookingResponseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface  BookingRepository extends JpaRepository<BookingEntity, Long> {

    @Query(nativeQuery = true,
            value = """
                        SELECT *
                        FROM
                            TB_BOOKING
                        WHERE
                            LOCAL_ID = :localId
                        AND
                            DATE = :date
                        AND
                            STATUS = 'ACTIVE'
                    """
    )
    List<BookingProjection> findBookingByDateAndLocal(LocalDate date, Long localId);

    @Query(nativeQuery = true,
            value = """
                        SELECT
                            b.id, b.date,
                            b.check_in,
                            b.check_out,
                            l.name as local_name,
                            b.course,
                            b.user_id
                        FROM
                            TB_BOOKING b
                        JOIN
                            TB_LOCAL l ON b.local_id = l.id
                        WHERE
                            b.user_id = :id
                        AND
                            b.status = 'ACTIVE'
                    """
    )
    List<BookingResponseProjection> findByUserId(Long id);

}


