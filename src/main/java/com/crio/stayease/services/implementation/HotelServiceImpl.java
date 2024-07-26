package com.crio.stayease.services.implementation;

import com.crio.stayease.entity.Hotel;
import com.crio.stayease.entity.Location;
import com.crio.stayease.exchange.HotelRequest;
import com.crio.stayease.repository.HotelRepository;
import com.crio.stayease.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    public Hotel create(HotelRequest hotelRequest) {
        Location location = new Location();
        location.setAddress(hotelRequest.getAddress());
        location.setLatitude(hotelRequest.getLatitude());
        location.setLongitude(hotelRequest.getLongitude());

        Hotel hotel = Hotel.builder()
                .name(hotelRequest.getName())
                .description(hotelRequest.getDescription())
                .noOfRooms(hotelRequest.getNoOfRooms().orElse(0))
                .location(location)
                .build();

        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel update(Long id, Map<String, Object> hotelRequest) {

        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Hotel not found"));

        if (hotelRequest.get("name")!=null) {
            existingHotel.setName((String) hotelRequest.get("name"));
        }
        if (hotelRequest.get("description")!=null) {
            existingHotel.setDescription((String) hotelRequest.get("description"));
        }
        if (hotelRequest.get("noOfRooms")!=null) {
            existingHotel.setNoOfRooms((int) hotelRequest.get("noOfRooms"));
        }

        // Update location
        Location existingLocation = existingHotel.getLocation();
        if (existingLocation == null) {
            existingLocation = new Location();
            existingHotel.setLocation(existingLocation);
        }
        if (hotelRequest.get("address")!=null) {
            existingLocation.setAddress((String) hotelRequest.get("address"));
        }
        if (hotelRequest.get("latitude")!=null) {
            existingLocation.setLatitude((Double) hotelRequest.get("latitude"));
        }
        if (hotelRequest.get("longitude")!=null) {
            existingLocation.setLongitude((Double) hotelRequest.get("longitude"));
        }

        return hotelRepository.save(existingHotel);
    }

    @Override
    public List<Hotel> get() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> get(Long id) {
        Optional<Hotel> o = hotelRepository.findById(id);
        if (o.isPresent()){
            return hotelRepository.findById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found");
        }
    }

    @Override
    public boolean delete(Long id) {
        Optional<Hotel> o = hotelRepository.findById(id);
        if (o.isPresent()){
            hotelRepository.deleteById(id);
            return true;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found");
        }
    }
}
