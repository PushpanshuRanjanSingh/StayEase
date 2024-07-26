package com.crio.stayease.controller;

import com.crio.stayease.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
private final BookingService bookingService;
    @GetMapping()
    public ResponseEntity<?> getHotelHavingRequiredRooms(@RequestParam(required = false) Integer room){
        return ResponseEntity.ok(bookingService.availableRooms(Optional.ofNullable(room)));
    }

}
