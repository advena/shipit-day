/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini.parking.groups;

import com.capgemini.ParkingPlaceDTO;
import java.util.Date;

/**
 *
 * @author advena
 */
public class ParkingPlace {

    private final ParkingStatus parkingStatus;
    private final long lastUpdateTimestamp;

    public ParkingPlace(ParkingStatus parkingStatus, long lastUpdateTimestamp) {
        this.parkingStatus = parkingStatus;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public ParkingPlaceDTO getParkingPlacesDTO() {
        return new ParkingPlaceDTO(parkingStatus.getFree(), new Date(lastUpdateTimestamp));
    }
    
}
