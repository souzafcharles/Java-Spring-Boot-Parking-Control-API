package com.souza.charles.parkingcontrolapi.controllers;
  /*
  Tutorial: Spring Boot | Complete Course | Parking Control API
  Instructor: Michelli Brito - Decoder
  Project adapted by: Charles Fernandes de Souza
  Date: February 25, 2025
 */

import com.souza.charles.parkingcontrolapi.dtos.ParkingSpotDTO;
import com.souza.charles.parkingcontrolapi.models.ParkingSpotModel;
import com.souza.charles.parkingcontrolapi.services.ParkingSpotService;
import com.souza.charles.parkingcontrolapi.utils.ParkingSpotMessages;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO) {
        if (parkingSpotService.existsByLicensePlateCar(parkingSpotDTO.licensePlateCar())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ParkingSpotMessages.LICENSE_PLATE_IN_USE);
        }
        if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDTO.parkingSpotNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ParkingSpotMessages.PARKING_SPOT_IN_USE);
        }
        if (parkingSpotService.existsByApartmentAndBlock(parkingSpotDTO.apartment(), parkingSpotDTO.block())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ParkingSpotMessages.APARTMENT_BLOCK_IN_USE);
        }
        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }

    @GetMapping
    public ResponseEntity<Page<ParkingSpotModel>> getAllParkingSpots(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable UUID id) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (parkingSpotModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ParkingSpotMessages.PARKING_SPOT_NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable UUID id) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (parkingSpotModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ParkingSpotMessages.PARKING_SPOT_NOT_FOUND);
        }
        parkingSpotService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(ParkingSpotMessages.PARKING_SPOT_DELETED_SUCCESS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable UUID id,
                                                    @RequestBody @Valid ParkingSpotDTO parkingSpotDTO) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (parkingSpotModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ParkingSpotMessages.PARKING_SPOT_NOT_FOUND);
        }
        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);
        parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
        parkingSpotModel.setRegistrationDate(parkingSpotModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
    }
}