package com.souza.charles.parkingcontrolapi.repositories;
  /*
  Tutorial: Spring Boot | Complete Course | Parking Control API
  Instructor: Michelli Brito - Decoder
  Project adapted by: Charles Fernandes de Souza
  Date: February 24, 2025
 */

import com.souza.charles.parkingcontrolapi.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

    boolean existsByLicensePlateCar(String licensePlateCar);
    boolean existsByParkingSpotNumber(String parkingSpotNumber);
    boolean existsByApartmentAndBlock(String apartment, String block);

}