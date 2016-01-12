/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini;

import com.capgemini.parking.places.ParkingGroupFactory;
import com.capgemini.parking.places.ParkingPlaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author advena
 */
@Repository
class ParkingPlacesRepository {

    @Autowired
    ParkingGroupFactory factory;

    ParkingPlaces getParkingPlaces() {
        return factory.getParkingPlaces();
    }
    
}
