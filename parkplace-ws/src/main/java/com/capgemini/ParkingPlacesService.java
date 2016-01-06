/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini;

import com.capgemini.parking.groups.ParkingPlaces;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author advena
 */
class ParkingPlacesService {

    @Autowired
    ParkingPlacesRepository parkingPlacesRepository;

    ParkingPlacesDTO getForCapgemini() {
        ParkingPlaces capgeminiParkingPlaces = parkingPlacesRepository.getForCapgemini();
        return capgeminiParkingPlaces.getParkingPlacesDTO();
        
    }
    
}
