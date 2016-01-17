/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini.update;

import com.capgemini.parking.places.ParkingPlaces;
import org.springframework.stereotype.Component;

/**
 *
 * @author advena
 */
@Component
public class ParkingPlacesContainer {

    private ParkingPlaces parkingPlaces = ParkingPlaces.empty;

    public ParkingPlaces getParkingPlaces() {
        return parkingPlaces;
    }

    public void setParkingPlaces(ParkingPlaces parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }
    
}
