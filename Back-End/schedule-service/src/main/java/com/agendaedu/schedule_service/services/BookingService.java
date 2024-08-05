package com.agendaedu.schedule_service.services;

import com.agendaedu.schedule_service.domain.booking.BookingDTO;
import com.agendaedu.schedule_service.domain.booking.BookingEntity;
import com.agendaedu.schedule_service.domain.local.Local;
import com.agendaedu.schedule_service.domain.user.User;
import com.agendaedu.schedule_service.projections.BookingProjection;
import com.agendaedu.schedule_service.repositories.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private LocalService localService;

    @Transactional
    public BookingDTO insert(BookingDTO bookingDTO) {
        BookingEntity booking = new BookingEntity(bookingDTO);

        booking.setLocal(new Local(localService.findById(bookingDTO.getLocalId())));
        booking.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        booking = this.bookingRepository.save(booking);
        return new BookingDTO(booking);
    }

    public List<BookingProjection> findBookingByDateAndLocal(LocalDate date, Long localId) {
        return this.bookingRepository.findBookingByDateAndLocal(date, localId);
    }

    public List<BookingDTO> findAll() {
        return this.bookingRepository.findAll().stream().map(BookingDTO::new).collect(Collectors.toList());
    }

}
