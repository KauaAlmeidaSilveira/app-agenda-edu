package com.agendaedu.schedule_service.services;

import com.agendaedu.schedule_service.domain.booking.BookingDTO;
import com.agendaedu.schedule_service.domain.booking.BookingEntity;
import com.agendaedu.schedule_service.domain.local.Local;
import com.agendaedu.schedule_service.domain.user.User;
import com.agendaedu.schedule_service.repositories.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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

}
