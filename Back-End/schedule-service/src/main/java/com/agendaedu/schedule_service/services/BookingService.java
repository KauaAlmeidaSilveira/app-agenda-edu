package com.agendaedu.schedule_service.services;

import com.agendaedu.schedule_service.domain.booking.BookingDTO;
import com.agendaedu.schedule_service.domain.booking.BookingEntity;
import com.agendaedu.schedule_service.domain.booking.BookingStatus;
import com.agendaedu.schedule_service.domain.localEntity.Local;
import com.agendaedu.schedule_service.domain.user.User;
import com.agendaedu.schedule_service.projections.BookingResponseProjection;
import com.agendaedu.schedule_service.repositories.BookingRepository;
import com.agendaedu.schedule_service.services.exceptions.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private LocalService localService;

    private final List<LocalTime> hours = new ArrayList<>(Arrays.asList(
            LocalTime.parse("07:00:00"), LocalTime.parse("08:00:00"), LocalTime.parse("09:00:00"),
            LocalTime.parse("10:00:00"), LocalTime.parse("11:00:00"), LocalTime.parse("12:00:00"),
            LocalTime.parse("13:00:00"), LocalTime.parse("14:00:00"), LocalTime.parse("15:00:00"),
            LocalTime.parse("16:00:00"), LocalTime.parse("17:00:00"), LocalTime.parse("18:00:00"),
            LocalTime.parse("19:00:00")
    ));

    @Transactional
    public BookingDTO insert(BookingDTO bookingDTO) {
        BookingEntity booking = new BookingEntity(bookingDTO);

        booking.setLocal(new Local(localService.findById(bookingDTO.getLocalId())));
        booking.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        booking.setStatus(BookingStatus.ACTIVE);

        booking = this.bookingRepository.save(booking);
        return new BookingDTO(booking);
    }

    @Transactional
    public BookingDTO disableBookingById(Long bookingId){
        BookingEntity booking = this.bookingRepository.findById(bookingId)
                .orElseThrow(() -> new NoSuchElementException("Booking não encontrado"));

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!booking.getUser().getId().equals(user.getId())){
            throw new InvalidCredentialsException("O agendamento não pertence ao usuario !!");
        }

        booking.setStatus(BookingStatus.DISABLED);
        booking = this.bookingRepository.save(booking);

        return new BookingDTO(booking);
    }

    @Transactional(readOnly = true)
    public List<BookingResponseProjection> findBookingByUserId() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.bookingRepository.findByUserId(user.getId());
    }

    @Transactional(readOnly = true)
    public List<BookingDTO> findBookingByDateAndLocal(LocalDate date, Long localId) {
        return this.bookingRepository.findBookingByDateAndLocal(date, localId).stream().map(BookingDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<BookingDTO> findAll() {
        return this.bookingRepository.findAll().stream().map(BookingDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<LocalTime> findPossiblesCheckIn(List<BookingDTO> bookingsFiltered) {
        List<LocalTime> possiblesCheckIn = new ArrayList<>(removeHours(this.hours, bookingsFiltered, true));
        possiblesCheckIn.remove(possiblesCheckIn.size() - 1);
        return possiblesCheckIn;
    }

    @Transactional(readOnly = true)
    public List<LocalTime> findPossiblesCheckOutWithCheckIn(List<BookingDTO> bookingsFiltered, LocalTime checkInSelected) {
        List<LocalTime> possiblesCheckOut = findPossiblesCheckOut(bookingsFiltered);

        possiblesCheckOut = possiblesCheckOut.stream().filter(h -> h.isAfter(checkInSelected)).toList();

        List<LocalTime> possiblesCheckOutWithCheckIn = new ArrayList<>();

        for (int i = 0; i < possiblesCheckOut.size(); i++) {
            possiblesCheckOutWithCheckIn.add(possiblesCheckOut.get(i));
            if (i + 1 < possiblesCheckOut.size() && !possiblesCheckOut.get(i + 1).equals(possiblesCheckOut.get(i).plusHours(1))) {
                break;
            }
        }

        return possiblesCheckOutWithCheckIn;
    }

    @Transactional(readOnly = true)
    private List<LocalTime> findPossiblesCheckOut(List<BookingDTO> bookingsFiltered) {
        List<LocalTime> possiblesCheckOut = new ArrayList<>(removeHours(this.hours, bookingsFiltered, false));
        possiblesCheckOut.remove(0);
        return possiblesCheckOut;
    }

    @Transactional(readOnly = true)
    private List<LocalTime> removeHours(List<LocalTime> hours, List<BookingDTO> bookingsFiltered, Boolean isCheckIn) {
        List<LocalTime> eliminados = new ArrayList<>();

        bookingsFiltered.forEach(booking -> {
            eliminados.add(isCheckIn ? booking.getCheckIn() : booking.getCheckOut());

            for (int i = booking.getCheckIn().plusHours(1).getHour();
                 i < booking.getCheckOut().getHour(); i++) {
                eliminados.add(LocalTime.of(i, 0));
            }
        });

        return hours.stream().filter(h -> !eliminados.contains(h)).toList();
    }

}
