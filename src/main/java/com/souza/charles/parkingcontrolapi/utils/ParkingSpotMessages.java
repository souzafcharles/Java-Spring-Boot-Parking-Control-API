package com.souza.charles.parkingcontrolapi.utils;
/*
Tutorial: Spring Boot | Complete Course | Parking Control API
Instructor: Michelli Brito - Decoder
Project adapted by: Charles Fernandes de Souza
Date: February 25, 2025
*/

public class ParkingSpotMessages {

    private ParkingSpotMessages() {
        throw new IllegalStateException("Utility class");
    }

    public static final String LICENSE_PLATE_IN_USE = "Conflict: License Plate Car is already in use!";
    public static final String PARKING_SPOT_IN_USE = "Conflict: Parking Spot is already in use!";
    public static final String APARTMENT_BLOCK_IN_USE = "Conflict: Parking Spot already registered for this apartment/block!";
    public static final String PARKING_SPOT_NOT_FOUND = "Parking Spot not found.";
    public static final String PARKING_SPOT_DELETED_SUCCESS = "Parking Spot deleted successfully.";
}