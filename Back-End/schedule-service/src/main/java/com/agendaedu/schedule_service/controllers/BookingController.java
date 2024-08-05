package com.agendaedu.schedule_service.controllers;

import com.agendaedu.schedule_service.domain.booking.BookingDTO;
import com.agendaedu.schedule_service.projections.BookingProjection;
import com.agendaedu.schedule_service.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping
    public ResponseEntity<BookingDTO> insert(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(service.insert(bookingDTO));
    }

    @GetMapping("/{date}/{localId}")
    public ResponseEntity<List<BookingProjection>> findBookingByDateAndLocal(
            @PathVariable LocalDate date,
            @PathVariable Long localId) {
        return ResponseEntity.ok(service.findBookingByDateAndLocal(date, localId));
    }

    @GetMapping
    public ResponseEntity<List<BookingDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
