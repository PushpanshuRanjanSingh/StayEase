package com.crio.stayease.services.implementation;

import com.crio.stayease.entity.Booking;
import com.crio.stayease.entity.Hotel;
import com.crio.stayease.exchange.BookingRequest;
import com.crio.stayease.repository.BookingRepository;
import com.crio.stayease.repository.HotelRepository;
import com.crio.stayease.security.repository.UserRepository;
import com.crio.stayease.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;
    private final BookingRepository bookingRepository;

    @Override
    public List<Hotel> availableRooms(Optional<Integer> room) {
        return hotelRepository.findHotelsByNoOfRoomsGreaterThanEqual(room.orElse(1));
    }

    @Override
    public Booking book(BookingRequest request) {
        return null;
    }

    @Override
    public Booking update(BookingRequest request) {
        return null;
    }

    @Override
    public Booking cancel(BookingRequest request) {
        return null;
    }

    @Override
    public Booking get() {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
