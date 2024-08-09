package com.agendaedu.schedule_service.controllers;

import com.agendaedu.schedule_service.domain.booking.BookingDTO;
import com.agendaedu.schedule_service.projections.BookingResponseProjection;
import com.agendaedu.schedule_service.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping("/new")
    public ResponseEntity<BookingDTO> insert(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(service.insert(bookingDTO));
    }

    @PatchMapping("/disable/{bookingId}")
    public ResponseEntity<BookingDTO> disableBookingById(@PathVariable Long bookingId) {
        return ResponseEntity.ok(service.disableBookingById(bookingId));
    }

    @GetMapping("/user/bookings")
    public ResponseEntity<List<BookingResponseProjection>> findBookingsByUserId() {
        return ResponseEntity.ok(service.findBookingByUserId());
    }

    @GetMapping("/checkin/{date}/{localId}")
    public ResponseEntity<List<LocalTime>> findPossiblesCheckIn(
            @PathVariable LocalDate date,
            @PathVariable Long localId) {
        List<BookingDTO> bookingFiltered = service.findBookingByDateAndLocal(date, localId);
        List<LocalTime> possiblesCheckIn = service.findPossiblesCheckIn(bookingFiltered);
        return ResponseEntity.ok(possiblesCheckIn);
    }

    @GetMapping("/checkout/{date}/{localId}")
    public ResponseEntity<List<LocalTime>> findPossiblesCheckOutWithCheckIn(
            @PathVariable LocalDate date,
            @PathVariable Long localId,
            @RequestParam LocalTime checkInSelected) {
        List<BookingDTO> bookingFiltered = service.findBookingByDateAndLocal(date, localId);
        List<LocalTime> possiblesCheckOutWithCheckIn = service.findPossiblesCheckOutWithCheckIn(bookingFiltered, checkInSelected);
        return ResponseEntity.ok(possiblesCheckOutWithCheckIn);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookingDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
