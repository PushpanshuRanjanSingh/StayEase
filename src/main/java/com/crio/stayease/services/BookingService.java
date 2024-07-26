package com.crio.stayease.services;

import com.crio.stayease.entity.Booking;
import com.crio.stayease.entity.Hotel;
import com.crio.stayease.exchange.BookingRequest;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Hotel> availableRooms(Optional<Integer> room);
    Booking book(BookingRequest request);
    Booking update(BookingRequest request);
    Booking cancel(BookingRequest request);
    Booking get();
    boolean delete(Long id);
}
