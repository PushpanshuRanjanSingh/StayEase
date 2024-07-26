package com.crio.stayease.controller;

import com.crio.stayease.entity.Hotel;
import com.crio.stayease.exchange.HotelRequest;
import com.crio.stayease.services.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("")
    public ResponseEntity<?> getAllHotels(){
        return ResponseEntity.ok(hotelService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable long id){
        return ResponseEntity.ok(hotelService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<?> saveHotel(@Valid @RequestBody HotelRequest hotel) {
        log.debug("Received request to save hotel: {}", hotel);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.debug("Current user: {}, Authorities: {}", auth.getName(), auth.getAuthorities());
        return ResponseEntity.ok(hotelService.create(hotel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable Long id, @RequestBody Map<String, Object> hotel){
        return ResponseEntity.ok(hotelService.update(id,hotel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHotelById(@PathVariable long id){
        return ResponseEntity.ok(hotelService.delete(id));
    }


}
