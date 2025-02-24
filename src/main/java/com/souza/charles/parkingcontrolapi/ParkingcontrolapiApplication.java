package com.souza.charles.parkingcontrolapi;
  /*
  Tutorial: Spring Boot | Complete Course | Parking Control API
  Instructor: Michelli Brito - Decoder
  Project adapted by: Charles Fernandes de Souza
  Date: February 24, 2025
 */

import com.souza.charles.parkingcontrolapi.environment.LoadEnvironment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingcontrolapiApplication {

    public static void main(String[] args) {
        LoadEnvironment.loadEnv();
        SpringApplication.run(ParkingcontrolapiApplication.class, args);
    }
}