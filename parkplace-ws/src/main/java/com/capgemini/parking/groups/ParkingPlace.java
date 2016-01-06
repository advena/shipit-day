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

    private CompanyName companyName;
    private ParkingStatus parkingStatus;
    private long lastUpdateTimestamp;

    public ParkingPlaceDTO getParkingPlacesDTO() {
        return new ParkingPlaceDTO(parkingStatus.getFree(), new Date(lastUpdateTimestamp));
    }
    
}
