/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini.parking.groups;

import com.capgemini.ParkingPlacesDTO;
import java.util.Date;

/**
 *
 * @author advena
 */
public class ParkingPlaces {

    private CompanyName companyName;
    private ParkingStatus parkingStatus;
    private long lastUpdateTimestamp;

    public ParkingPlacesDTO getParkingPlacesDTO() {
        return new ParkingPlacesDTO(parkingStatus.getFree(), new Date(lastUpdateTimestamp));
    }
    
}
