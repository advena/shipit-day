/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini;

import com.capgemini.parking.places.ParkingPlace;
import com.capgemini.parking.places.ParkingPlaceDTO;
import com.capgemini.parking.places.ParkingPlaces;
import com.capgemini.update.ParkingPlacesContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author advena
 */
@Service
class ParkingPlaceInfoService {

    @Autowired
    private ParkingPlacesContainer container;

    ParkingPlaceDTO getForCapgemini() {
        ParkingPlaces parkingPlaces = getParkingPlaces();
        ParkingPlace capgeminiParkingPlaces = parkingPlaces.getCapgeminiParkingPlace();
        return capgeminiParkingPlaces.getParkingPlacesDTO();

    }

    ParkingPlaceDTO getForIdea() {
        ParkingPlaces parkingPlaces = getParkingPlaces();
        ParkingPlace ideaParkingPlaces = parkingPlaces.getIdeaParkingPlace();
        return ideaParkingPlaces.getParkingPlacesDTO();
    }

    ParkingPlaceDTO getForMerck() {
        ParkingPlaces parkingPlaces = getParkingPlaces();
        ParkingPlace merckParkingPlaces = parkingPlaces.getMerckParkingPlace();
        return merckParkingPlaces.getParkingPlacesDTO();
    }

    ParkingPlaceDTO getForPorp() {
        ParkingPlaces parkingPlaces = getParkingPlaces();
        ParkingPlace porpParkingPlaces = parkingPlaces.getPorpParkingPlace();
        return porpParkingPlaces.getParkingPlacesDTO();
    }

    ParkingPlaceDTO getForPfleiderer() {
        ParkingPlaces parkingPlaces = getParkingPlaces();
        ParkingPlace pfleidererParkingPlaces = parkingPlaces.getPfleidererParkingPlace();
        return pfleidererParkingPlaces.getParkingPlacesDTO();
    }

    private ParkingPlaces getParkingPlaces() {
        return container.getParkingPlaces();
    }

}
