package com.crio.stayease.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingRequest {
    private Long userID;
    private Long hotelID;
}
