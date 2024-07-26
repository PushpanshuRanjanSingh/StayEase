package com.crio.stayease.exchange;

import com.crio.stayease.entity.Location;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelRequest {
    @NotEmpty(message = "Hotel name cannot be empty")
    @NotBlank(message = "Hotel name cannot be blank")
    private String name;

    @NotEmpty(message = "Description cannot be empty")
    @NotBlank(message = "Description cannot be blank")
    private String description;

    private Optional<Integer> noOfRooms;

    @NotNull(message = "Address cannot be null")
    private String address;

    private Double latitude;
    private Double longitude;
}
