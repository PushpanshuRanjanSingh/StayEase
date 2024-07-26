package com.crio.stayease.repository;

import com.crio.stayease.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findHotelsByNoOfRoomsGreaterThanEqual(int roomAvailable);
}
