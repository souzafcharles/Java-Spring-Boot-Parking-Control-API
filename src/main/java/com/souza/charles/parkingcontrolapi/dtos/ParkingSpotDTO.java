package com.souza.charles.parkingcontrolapi.dtos;
  /*
  Tutorial: Spring Boot | Complete Course | Parking Control API
  Instructor: Michelli Brito - Decoder
  Project adapted by: Charles Fernandes de Souza
  Date: February 24, 2025
 */

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ParkingSpotDTO(
        @NotBlank
        String parkingSpotNumber,

        @NotBlank
        @Size(max = 8)
        String licensePlateCar,

        @NotBlank
        String brandCar,

        @NotBlank
        String modelCar,

        @NotBlank
        String colorCar,

        @NotBlank
        String responsibleName,

        @NotBlank
        String apartment,

        @NotBlank
        String block
) {
}
