package com.agendaedu.schedule_service.controllers;

import com.agendaedu.schedule_service.domain.dto.BookingDTO;
import com.agendaedu.schedule_service.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping
    public ResponseEntity<BookingDTO> insert(@RequestBody BookingDTO bookingDTO){
        return ResponseEntity.ok(service.insert(bookingDTO));
    }

    @GetMapping
    public ResponseEntity<List<BookingDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

}
