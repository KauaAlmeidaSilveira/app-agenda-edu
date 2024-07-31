package com.agendaedu.schedule_service.services;

import com.agendaedu.schedule_service.domain.booking.BookingEntity;
import com.agendaedu.schedule_service.domain.booking.BookingDTO;
import com.agendaedu.schedule_service.repositories.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;

    @Transactional
    public BookingDTO insert(BookingDTO bookingDTO) {
        BookingEntity booking = new BookingEntity();
        booking = repository.save(booking);
        return new BookingDTO(booking);
    }

    public List<BookingDTO> findAll() {
        return repository.findAll().stream().map(BookingDTO::new).toList();
    }

}
